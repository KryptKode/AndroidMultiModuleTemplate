package com.kryptkode.core.remote.mapper

interface RemoteMapper<in R, out D> {
    fun mapToEntity(remote: R): D
}
