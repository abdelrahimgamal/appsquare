package myapp.appsquare.appsquare.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import myapp.appsquare.appsquare.data.api.DataAPI
import myapp.appsquare.appsquare.data.dataSource.DataRemoteDataSource
import myapp.appsquare.appsquare.data.repository.DataRepository
import retrofit2.Retrofit
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideExternalScope() =
        CoroutineScope(SupervisorJob() + Dispatchers.Default)

    @Provides
    @Singleton
    fun provideDataApi(retrofit: Retrofit): DataAPI = retrofit.create(DataAPI::class.java)


    @Provides
    @Singleton
    fun provideDataRemoteDataSource(dataApi: DataAPI) =
        DataRemoteDataSource(dataApi)



    @Provides
    @Singleton
    fun provideDataRepository(
        remoteDataSource: DataRemoteDataSource,
        coroutineScope: CoroutineScope,
    ) =
        DataRepository(remoteDataSource,coroutineScope)

}