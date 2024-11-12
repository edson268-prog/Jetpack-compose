package com.edsondev26.jetpackcompose.ui.paging.data

import com.edsondev26.jetpackcompose.ui.paging.data.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface RickMortyApiService {
    @GET("/api/character/")
    suspend fun getCharacters(@Query("page") page: Int):ResponseWrapper
}