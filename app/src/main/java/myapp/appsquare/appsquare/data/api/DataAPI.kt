package myapp.appsquare.appsquare.data.api

import myapp.appsquare.appsquare.data.models.ServerResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface DataAPI {
    @POST("sign-up")
    suspend fun getProducts(@Body registerData: RegisterData): Response<ServerResponse<String>>


    @POST("posts")
    @Multipart
    suspend fun postPost(@Part file: MultipartBody.Part)
}