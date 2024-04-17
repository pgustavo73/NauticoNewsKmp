package presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.BaseResult
import repository.NewsRepository

class NewsViewModel(private val repository: NewsRepository) : ViewModel() {

    private val _stateUI = MutableStateFlow(NewStateUI())
    val stateUI: StateFlow<NewStateUI> get() = _stateUI.asStateFlow()

    init {
        getNews()
    }

    private fun getNews() {
        _stateUI.update { _stateUI.value.copy(error = null, loading = true) }

        viewModelScope.launch(Dispatchers.Main) {
            when (val result = repository.getNews()) {
                is BaseResult.Error -> _stateUI.update {
                    _stateUI.value.copy(
                        error = result.exception,
                        loading = false
                    )
                }

                is BaseResult.Success -> _stateUI.update {
                    _stateUI.value.copy(
                        news = result.data,
                        error = null,
                        loading = false
                    )
                }
            }
        }
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

}