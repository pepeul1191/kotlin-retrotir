package pe.edu.ulima.services

import pe.edu.ulima.models.beans.Pokemon
import pe.edu.ulima.models.responses.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET("/pokemon/list")
    fun fetchAll(
        @Query("name") name: String,
        @Query("generation_ids") generationIds: String
    ): Call<PokemonList>
}