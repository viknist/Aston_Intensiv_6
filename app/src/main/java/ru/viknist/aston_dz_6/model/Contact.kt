package ru.viknist.aston_dz_6.model

data class Contact(
    val id: Int,
    var phone: String,
    var firstName: String,
    var lastName: String,
    var imageURI: String
) : java.io.Serializable
