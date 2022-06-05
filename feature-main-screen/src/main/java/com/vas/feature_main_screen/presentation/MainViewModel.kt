package com.vas.feature_main_screen.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vas.core.utils.Resource
import com.vas.feature_main_screen.domain.useCase.GetCharacterListUseCase
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val getCharacterListUseCase: GetCharacterListUseCase) : ViewModel() {

    fun getCharacterList() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = getCharacterListUseCase.execute()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error Occurred!"))
        }
    }

}