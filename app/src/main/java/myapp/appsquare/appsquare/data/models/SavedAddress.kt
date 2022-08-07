package myapp.appsquare.appsquare.data.models

import java.io.Serializable

data class SavedAddress(
    var country: String,
    var city: String,
    var street: String,
):Serializable
