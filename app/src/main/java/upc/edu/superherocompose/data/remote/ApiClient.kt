package upc.edu.superherocompose.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val API_BASE_URL = "https://www.superheroapi.com/api.php/"

    private var heroService: HeroService? = null

    fun getHeroService(): HeroService {

        if (heroService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            heroService = retrofit.create(HeroService::class.java) // <--- Here is the important part!
        }

        return heroService!!

    }
}