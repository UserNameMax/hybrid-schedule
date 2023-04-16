package ru.mishenko.maksim.hybrid.screen

import ru.mishenko.maksim.hybrid.domain.model.Event

data class State(
    val isLoading: Boolean,
    val isData: Boolean,
    val isError: Boolean,
    val error: String,
    val data: List<Event>
) {
    companion object {
        val defaultState = State(
            isLoading = false,
            isError = false,
            isData = false,
            error = "",
            data = listOf()
        )
    }
}
