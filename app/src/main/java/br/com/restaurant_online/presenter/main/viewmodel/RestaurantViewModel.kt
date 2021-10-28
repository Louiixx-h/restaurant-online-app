package br.com.restaurant_online.presenter.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.restaurant_online.component_dto.Category
import br.com.luishenrique.restaurant_online.domain.RestaurantUseCase
import kotlinx.coroutines.launch

class RestaurantViewModel(private val useCase: RestaurantUseCase): ViewModel() {

    private val categories = MutableLiveData<List<br.com.restaurant_online.component_dto.Category>>()
    val _categories: LiveData<List<br.com.restaurant_online.component_dto.Category>> = categories

    fun findAllCategories(useMock: Boolean = false) {
        if (!useMock) viewModelScope.launch {
            categories.postValue(useCase.findAllCategories())
        } else categories.postValue(useCase.findAllCategoriesMock())
    }
}