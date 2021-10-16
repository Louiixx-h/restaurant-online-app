package br.com.luishenrique.restaurantonline.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.luishenrique.restaurantonline.data.model.Category
import br.com.luishenrique.restaurantonline.data.repository.RestaurantOnlineRepository
import kotlinx.coroutines.launch

class RestaurantViewModel(private val repository: RestaurantOnlineRepository): ViewModel() {

    private val categories = MutableLiveData<List<Category>>()
    val _categories: LiveData<List<Category>> = categories

    fun findAllCategories(useMock: Boolean) {
        if (!useMock) viewModelScope.launch {
            categories.postValue(repository.findAllCategories())
        } else categories.postValue(repository.finAllCategoriesMock())
    }
}