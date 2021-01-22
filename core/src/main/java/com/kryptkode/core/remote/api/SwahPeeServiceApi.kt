package com.kryptkode.core.remote.api

import com.kryptkode.core.remote.entities.character.CharacterResponse
import com.kryptkode.core.remote.entities.film.FilmRemote
import com.kryptkode.core.remote.entities.planet.PlanetRemote
import com.kryptkode.core.remote.entities.specie.SpecieRemote
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface SwahPeeServiceApi {

    @GET("people/")
    suspend fun searchCharacters(@Query("search") params: String): CharacterResponse

    @GET
    suspend fun getSpecieDetails(@Url speciesUrl: String): SpecieRemote

    @GET
    suspend fun getFilmDetails(@Url filmsUrl: String): FilmRemote

    @GET
    suspend fun getPlanet(@Url planetUrl: String): PlanetRemote
}
