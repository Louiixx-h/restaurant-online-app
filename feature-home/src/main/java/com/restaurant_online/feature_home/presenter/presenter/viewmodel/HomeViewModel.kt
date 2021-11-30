package com.restaurant_online.feature_home.presenter.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.restaurant_online.component_domain.RestaurantUseCase
import br.com.restaurant_online.component_dto.Category
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: RestaurantUseCase): ViewModel() {

    private val categories = MutableLiveData<List<Category>>()
    val _categories: LiveData<List<Category>> = categories

    fun findAllCategories(useMock: Boolean = false) {
        if (!useMock) viewModelScope.launch {
            categories.postValue(useCase.findAllCategories())
        } else categories.postValue(useCase.findAllCategoriesMock())
    }
}