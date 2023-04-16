package ru.mishenko.maksim.hybrid.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.mishenko.maksim.hybrid.core.network.entity.Either
import ru.mishenko.maksim.hybrid.domain.useCase.GetEventsUseCase
import javax.inject.Inject

@HiltViewModel
class ScreenViewModel @Inject constructor(private val GetEvents: GetEventsUseCase): ViewModel() {
    private var mutableState = MutableStateFlow(State.defaultState)
    val state = mutableState.asStateFlow()

    init{
        mutableState.update { it.copy(isLoading = true) }
        load()
    }
    fun load() = viewModelScope.launch {
        val timetable = GetEvents()
        when(timetable){
            is Either.Failure -> mutableState.update { it.copy(isLoading = false, isError = true, error = timetable.error) }
            is Either.Success -> mutableState.update { it.copy(isLoading = false, isData = true, data = timetable.data) }
        }
    }
}