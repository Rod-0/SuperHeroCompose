package upc.edu.superherocompose.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import upc.edu.superherocompose.data.model.Hero
import upc.edu.superherocompose.data.model.HeroResponse

interface HeroService {
    @GET("{apiToken}/search/{textQuery}")
    fun searchHeroes(
        @Path("apiToken") apiToken: String = "10157703717092094",
        @Path("textQuery") textQuery: String
    ): Call<HeroResponse>

    @GET("{apiToken}/{id_superhero}")
    fun searchById(
        @Path("apiToken") apiToken: String = "10157703717092094",
        @Path("id_superhero") heroId: String
    ): Call<Hero>


}