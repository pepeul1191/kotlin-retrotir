package pe.edu.ulima.ui.app.viewmodels

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.configs.BackendClient
import pe.edu.ulima.models.beans.Imagen
import pe.edu.ulima.models.beans.Pokemon
import pe.edu.ulima.services.ImagenService
import pe.edu.ulima.services.PokemonService
import pe.edu.ulima.services.SeguidorService
import kotlin.concurrent.thread

class PokemonViewModel: ViewModel(){
    private val _pokemons = mutableStateOf<List<Pokemon>?>(
        listOf()
    )
    val pokemons get() = _pokemons.value
    fun setPokemons(pokemonName: String, activity: Activity) {
        val apiService = BackendClient.buildService(PokemonService::class.java)
        thread{
            try {
                val response = apiService.fetchAll("", "").execute()
                if (response.isSuccessful) {
                    _pokemons.value = response.body()
                    println(response.body())
                }
            }
            catch (e: Exception) {
                e.printStackTrace()
                activity.runOnUiThread{
                    Toast.makeText(
                        activity,
                        "Error HTTP: No se pudo traer la lista de pokemones",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            // _pokemons.value =
        }
    }

    private val _imagenes = mutableStateOf<List<Imagen>?>(
        listOf()
    )
    val imagenes get() = _imagenes.value
    fun setImagenes(userId: Int) {
        _imagenes.value = ImagenService.fetchByUserId(userId)
    }

    private val _selectedId = mutableStateOf<Int?>(
        null
    )
    val selectedId get() = _selectedId.value
    fun setSelectedId(selectedId: Int) {
        _selectedId.value = selectedId
    }

    private val _seguidores = MutableLiveData<Int>(
        0
    )
    val seguidores get() = _seguidores
    fun setSeguidores(userId: Int) {
        _seguidores.postValue(SeguidorService.countByUserId(userId))
    }

    private val _seguidos = MutableLiveData<Int>(
        0
    )
    val seguidos get() = _seguidos
    fun setSeguidos(userId: Int) {
        _seguidos.postValue(SeguidorService.countSeguidosBySeId(userId))
    }
}