package com.example.daytracker.ui.theme.calendarElements

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.*
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import com.example.daytracker.R

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun CalendarView(){
    val currentMonth = YearMonth.now()
    val daysInMonth = currentMonth.lengthOfMonth()
    val firstDayOfMonth = currentMonth.atDay(1).dayOfWeek.value % 7

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        MonthHeader(currentMonth)
        WeekDaysHeader()
        DaysGrid(daysInMonth, firstDayOfMonth)
    }
}

@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun MonthHeader(currentMonth: YearMonth) {
    BasicText(
        text = "${currentMonth.month.getDisplayName(TextStyle.FULL, Locale.getDefault())} ${currentMonth.year}",
        style = MaterialTheme.typography.headlineMedium,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

@Composable
fun WeekDaysHeader() {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        val daysOfWeek = listOf("Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat")
        daysOfWeek.forEach { day ->
            Text(text = day, modifier = Modifier.weight(1f), textAlign = Center)
        }
    }
}

@Composable
fun DaysGrid(daysInMonth: Int, firstDayOfMonth: Int) {
    val rows = (daysInMonth + firstDayOfMonth + 6) / 7
    Log.i("TAG", "daysInMonth: $daysInMonth")
    Log.i("TAG", "firstDayOfMonth: $firstDayOfMonth")
    Log.i("TAG", "rows: $rows")

    Column(modifier = Modifier.fillMaxSize(1f)) {
        for (row in 0 until rows) {
            Row(modifier = Modifier.fillMaxWidth()) {
                for (column in 0..6) {
                    val day = row * 7 + column - firstDayOfMonth + 1
                    if (day in 1..daysInMonth) {
                        Box(modifier = Modifier
                            .weight(1f)
                            .border(1.dp, Color.Magenta, shape = RoundedCornerShape(16.dp))
                            .height(128.dp)
                        ){
                            Text(
                                text = day.toString(),
                                modifier = Modifier
                                    .padding(vertical = 3.dp, horizontal = 10.dp)
                                    .align(Alignment.TopStart),
                            )
                            Image(
                                painter = painterResource(id = R.drawable.green_face),
                                contentDescription = "Centered SVG",
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(top = 16.dp)
                            )
                        }
                    } else {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}