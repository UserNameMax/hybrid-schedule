package ru.mishenko.maksim.hybrid.screen

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ru.mishenko.maksim.hybrid.domain.model.Event
import ru.mishenko.maksim.hybrid.utils.getDate
import ru.mishenko.maksim.hybrid.utils.separaateOnDay
import java.util.*

@Composable
fun Screen(viewModel: ScreenViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    when {
        state.isError -> Text("error\n${state.error}")
        state.isData -> Column(
            Modifier.verticalScroll(rememberScrollState())
        ) {
            for ((day, events) in separaateOnDay(state.data)) {
                DayCard(day, events)
                Spacer(Modifier.height(10.dp))
            }
        }
        state.isLoading -> Text("Loading")
    }
}

@Composable
fun DayCard(day: GregorianCalendar, events: List<Event>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(getDate(day))
        Spacer(modifier = Modifier.height(5.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White, RectangleShape)
                .padding(10.dp)
        ) {
            for (event in events) {
                Text(event.name)
                Text(getDate(event.start))
                Spacer(Modifier.height(20.dp))
            }
        }
    }

}