package pe.edu.ulima.models.beans

import com.google.gson.annotations.SerializedName

data class Usuario (
    var id: Int = 0,
    @SerializedName("user")
    var usuario: String = "",
    var contrasenia: String = "",
    @SerializedName("name")
    var nombre: String = "",
    @SerializedName("email")
    var correo: String = "",
    @SerializedName("image_url")
    var imagen: String = "",
)