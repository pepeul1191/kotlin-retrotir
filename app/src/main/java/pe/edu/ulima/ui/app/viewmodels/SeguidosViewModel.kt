package pe.edu.ulima.ui.app.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.ulima.models.beans.Usuario
import pe.edu.ulima.services.SeguidorService

class SeguidosViewModel: ViewModel() {
    private val _id = MutableLiveData<Int>(0)
    var id: LiveData<Int> = _id
    fun updateId(it: Int){
        _id.postValue(it)
    }

    private val _usuario = MutableLiveData<String>("")
    var usuario: LiveData<String> = _usuario
    fun updateUsuario(it: String){
        _usuario.postValue(it)
    }

    private val _usuarios = mutableStateOf<List<Usuario>?>(
        listOf()
    )
    val usuarios get() = _usuarios.value
    fun setUsuarios(userId: Int) {
        _usuarios.value = SeguidorService.fetchSeguidores(userId)
    }
}