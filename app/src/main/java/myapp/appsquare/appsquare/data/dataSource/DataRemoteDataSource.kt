package myapp.appsquare.appsquare.data.dataSource

import myapp.appsquare.appsquare.data.api.DataAPI
import myapp.appsquare.appsquare.data.models.Product
import myapp.appsquare.appsquare.data.models.Resource
import myapp.appsquare.appsquare.getResponse
import javax.inject.Inject

class DataRemoteDataSource @Inject constructor(
    private val dataAPI: DataAPI,

) {

    suspend fun getProducts(): Resource<ArrayList<Product>> {
        return getResponse(
            request = {
                dataAPI.getProducts()
            },
            defaultErrorMessage = "Error fetching Products"
        )
    }

}