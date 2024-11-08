package com.example.timetable.screens

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.testproj.LessonCard
import com.example.timetable.Lesson
import com.example.timetable.R
import com.mrerror.singleRowCalendar.SingleRowCalendar
import java.time.ZoneId
import java.time.temporal.WeekFields
import java.util.Date
import java.util.Locale

@Composable
fun ViewLessons()
{
    val lessons = mapOf(
        0 to mapOf(
            0 to listOf(
                Lesson("12:00","21:00","Пн","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            1 to listOf(
                Lesson("12:00","21:00","Вт","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            2 to listOf(
                Lesson("12:00","21:00","Ср","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            3 to listOf(
                Lesson("12:00","21:00","Чт","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            4 to listOf(
                Lesson("12:00","21:00","Пт","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            5 to listOf(
                Lesson("12:00","21:00","Сб","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            6 to listOf(
                Lesson("12:00","21:00","Вскр","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),),
        1 to mapOf(
            0 to listOf(
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            1 to listOf(
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            2 to listOf(
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            3 to listOf(
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            4 to listOf(
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            5 to listOf(
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),
            6 to listOf(
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
                Lesson("12:00","21:00","АИС","216*","Палехова О.И."),
            ),)
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val day = remember { mutableStateOf(Date()) }

        SingleRowCalendar(
            onSelectedDayChange = { selectedDate -> // верхний календарь
                day.value = selectedDate
            },
            selectedDayBackgroundColor = Color(0xFF8C2AC8)
        )

            DayLessons(date = day.value, lessons = lessons[0])
        }

    }




@Composable
fun DayLessons(date: Date, lessons: Map<Int,List<Lesson>>?) {

    val day : Int
    if (date.day == 0) day = 6
    else day = date.day - 1
    Column(modifier = Modifier.verticalScroll(state = ScrollState(1))) {
        for (lesson in lessons?.get(day)!!) {
            LessonCard(lesson)
        }
    }


}