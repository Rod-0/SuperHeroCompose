package upc.edu.superherocompose.data.model

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    val results: List<Hero>
)

data class Hero(
    val id: String,
    val name: String,
    val image: HeroImage,
    val biography:Biography,
    @SerializedName("powerstats")
    val powerStats: PowerStats
)

data class HeroImage(
    val url: String
)

data class Biography(
    @SerializedName("full-name")
    val fullName: String,
    @SerializedName("place-of-birth")
    val birthplace: String,
    val publisher: String
)

data class PowerStats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

