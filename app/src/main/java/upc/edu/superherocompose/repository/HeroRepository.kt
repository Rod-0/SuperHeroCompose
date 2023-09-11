package upc.edu.superherocompose.repository

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upc.edu.superherocompose.data.model.Hero
import upc.edu.superherocompose.data.model.HeroResponse
import upc.edu.superherocompose.data.remote.ApiClient
import upc.edu.superherocompose.data.remote.HeroService
import upc.edu.superherocompose.utils.Result


class HeroRepository(val heroService: HeroService = ApiClient.getHeroService()) {

    fun searchHeroes(name: String, callback: (Result<List<Hero>>)->Unit) {
        val searchByName = heroService.searchHeroes(textQuery = name)
        searchByName.enqueue(object: Callback<HeroResponse> {
            override fun onResponse(call: Call<HeroResponse>, response: Response<HeroResponse>) {
                if(response.isSuccessful) {
                    callback(Result.Success(response.body()!!.results))
                }
            }

            override fun onFailure(call: Call<HeroResponse>, t: Throwable) {
                callback(Result.Error(t.localizedMessage ?: "Error"))
            }

        })
    }
}
