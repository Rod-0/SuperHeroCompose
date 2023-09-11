package upc.edu.superherocompose.data.model

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    val results: List<Hero>
)

data class Hero(
    val id: Int,
    val name: String,
    val image: HeroImage,
    val biography:Biography
)

data class HeroImage(
    val url: String
)

data class Biography(
    @SerializedName("full-name")
    val fullName: String
)