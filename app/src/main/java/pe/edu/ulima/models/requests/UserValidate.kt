package pe.edu.ulima.models.requests

import com.google.gson.annotations.SerializedName

data class UserValidate(
    @SerializedName("user")
    val usuario: String,
    @SerializedName("password")
    var contrasenia: String
)