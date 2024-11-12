package com.edsondev26.jetpackcompose.ui.paging.data.response

import com.google.gson.annotations.SerializedName

class ResponseWrapper (
    @SerializedName("info") val information:InfoResponse,
    @SerializedName("results") val results:List<CharacterResponse>,
)