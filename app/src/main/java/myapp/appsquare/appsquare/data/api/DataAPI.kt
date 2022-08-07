package myapp.appsquare.appsquare.data.api

import myapp.appsquare.appsquare.data.models.Product
import myapp.appsquare.appsquare.data.models.ServerResponse
import retrofit2.Response
import retrofit2.http.GET

interface DataAPI {
    @GET("products")
    suspend fun getProducts(
    ): Response<ServerResponse<ArrayList<Product>>>
}