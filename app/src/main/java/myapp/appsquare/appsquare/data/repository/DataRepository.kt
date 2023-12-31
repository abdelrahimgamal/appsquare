package myapp.appsquare.appsquare.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.coroutines.withContext
import myapp.appsquare.appsquare.data.api.DataAPI
import myapp.appsquare.appsquare.data.dataSource.DataRemoteDataSource
import myapp.appsquare.appsquare.data.models.Product
import myapp.appsquare.appsquare.data.models.Resource
import myapp.appsquare.appsquare.data.models.Status
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val dataSource: DataRemoteDataSource,
    private val externalScope: CoroutineScope
) {
    suspend fun getProducts(): Resource<ArrayList<Product>> {
        return withContext(externalScope.coroutineContext) {
            return@withContext dataSource.getProducts()
        }
    }


}