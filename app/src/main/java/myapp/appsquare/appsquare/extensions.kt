package myapp.appsquare.appsquare

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import myapp.appsquare.appsquare.data.models.Resource
import myapp.appsquare.appsquare.data.models.ServerResponse
import retrofit2.Response


suspend fun <T> getResponse(
    request: suspend () -> Response<ServerResponse<T>>,
    defaultErrorMessage: String
): Resource<T> {
    return try {
        val result = request.invoke()
        if (result.isSuccessful) {
            val response: ServerResponse<T>? = result.body()
            return Resource.success(response?.data, response?.message)
        } else {
            val gson = Gson()
            val type = object : TypeToken<ServerResponse<String>?>() {}.type
            val errorResponse: ServerResponse<String> =
                gson.fromJson(result.errorBody()!!.charStream(), type)
            Resource.error(errorResponse.message, null)
        }
    } catch (e: Throwable) {
        e.printStackTrace()
        Resource.error(defaultErrorMessage, null)
    }
}