package ru.mishenko.maksim.hybrid.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import ru.mishenko.maksim.hybrid.utils.getDate
import java.util.*

@Composable
fun Screen(viewModel: ScreenViewModel = hiltViewModel()){
    val state by viewModel.state.collectAsState()
    when{
        state.isError -> Text("error\n${state.error}")
        state.isData -> Column {
            Text(text = getDate(GregorianCalendar()))
            for (event in state.data){
                Text("${event.name} - ${getDate(event.start)}")
            }
        }
        state.isLoading -> Text("Loading")
    }
}