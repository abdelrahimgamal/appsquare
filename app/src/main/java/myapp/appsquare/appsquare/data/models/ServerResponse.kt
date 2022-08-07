package myapp.appsquare.appsquare.data.models

data class ServerResponse<T>(val success: Boolean, val data: T, val message: String)