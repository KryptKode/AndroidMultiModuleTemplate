package com.kryptkode.core.remote.api

import android.annotation.SuppressLint
import com.squareup.moshi.Moshi
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSocketFactory
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object SwahPeeServiceApiFactory {

    fun makeSwahPeeService(moshi: Moshi, isDebug: Boolean): SwahPeeServiceApi {
        val okHttpClient = makeUnsafeOkHttpClient(
            makeLoggingInterceptor((isDebug))
        )
        return makeSwahPeeService(okHttpClient, moshi)
    }

    private fun makeSwahPeeService(client: OkHttpClient, moshi: Moshi): SwahPeeServiceApi {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        return retrofit.create(SwahPeeServiceApi::class.java)
    }

    private fun makeOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(HttpsEnforcerInterceptor())
            .connectTimeout(MAX_TIMEOUT_SECS, TimeUnit.SECONDS)
            .readTimeout(MAX_TIMEOUT_SECS, TimeUnit.SECONDS)
            .build()
    }

    @SuppressLint("TrustAllX509TrustManager")
    private fun makeUnsafeOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        // Create a trust manager that does not validate certificate chains
        val trustAllCerts: Array<TrustManager> = arrayOf<TrustManager>(
            object : X509TrustManager {
                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }

                override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                    // IGNORE
                }

                override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {
                    // IGNORE
                }
            }
        )

        // Install the all-trusting trust manager
        val sslContext: SSLContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())
        // Create an ssl socket factory with our all-trusting manager
        val sslSocketFactory: SSLSocketFactory = sslContext.socketFactory
        val builder = OkHttpClient.Builder()
        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        builder.hostnameVerifier { _, _ ->
            true
        }
            .addInterceptor(interceptor)
            .addInterceptor(HttpsEnforcerInterceptor())
            .connectTimeout(MAX_TIMEOUT_SECS, TimeUnit.SECONDS)
            .readTimeout(MAX_TIMEOUT_SECS, TimeUnit.SECONDS)
        return builder.build()
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = if (isDebug) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return logging
    }

    private const val MAX_TIMEOUT_SECS = 90L
}
