package com.edsondev26.jetpackcompose.ui.paging.data.response

import com.edsondev26.jetpackcompose.ui.paging.presentation.model.CharacterModel
import com.google.gson.annotations.SerializedName

data class CharacterResponse (
    @SerializedName("id") val id:Int,
    @SerializedName("name") val name:String,
    @SerializedName("status") val status:String,
    @SerializedName("image") val image:String,
){
    fun toPresentation():CharacterModel{
        return CharacterModel(
            id = id,
            name = name,
            image = image,
            isAlive = status == "Alive"
        )
    }
}