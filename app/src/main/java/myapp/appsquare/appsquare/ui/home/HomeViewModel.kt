package myapp.appsquare.appsquare.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import myapp.appsquare.appsquare.data.models.Product
import myapp.appsquare.appsquare.data.models.Resource
import myapp.appsquare.appsquare.data.repository.DataRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val dataRepository: DataRepository) : ViewModel() {
    var fetchHomeJob: Job? = null
    private val _products = MutableLiveData<Resource<ArrayList<Product>>>()
    val products: LiveData<Resource<ArrayList<Product>>> = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        fetchHomeJob?.cancel()
        fetchHomeJob = viewModelScope.launch {
            val products = dataRepository.getProducts()
            products.let {
                _products.value = it
            }
        }
    }


    override fun onCleared() {
        fetchHomeJob?.cancel()
        super.onCleared()
    }
}