package com.example.testproj

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.center
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.timetable.R
import com.example.timetable.data.domain.model.Lesson
import com.mrerror.singleRowCalendar.SingleRowCalendarDefaults.Blue600
import java.text.SimpleDateFormat
import java.util.Locale


fun formatTime(time: String): String {
    val inputFormat = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    return try {
        val date = inputFormat.parse(time)
        outputFormat.format(date ?: "")
    } catch (e: Exception) {
        time // возвращает оригинальную строку в случае ошибки
    }
}

@Composable
fun LessonCard(
    lesson: Lesson,
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = Color.Transparent
        ),
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .padding(vertical = 5.dp, horizontal = 20.dp)
            .shadow(elevation = 10.dp)

        ,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            // Время пары
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = formatTime(lesson.start),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 12.sp,
                    color = Color.Black,
                )
                Image(
                    painter = painterResource(id = R.drawable.timeicon),
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp).drawBehind {
                            drawLine(color = Blue600,this.size.center.minus(
                                Offset(-70f,200f)
                            ),this.size.center.plus(
                                Offset(70f,200f)
                            ), strokeWidth = 3f)
                        },
                )
                Text(
                    text = formatTime(lesson.end),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 12.sp,
                    color = Color.Black
                )
            }

            // Описание пары
            Column(
                modifier = Modifier
                    .fillMaxSize().padding(top = 15.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                horizontalAlignment = Alignment.Start
            ) {

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    Text(
                        text = if (lesson.title.isNullOrBlank()) "" else lesson.title,//lesson.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(1000),
                        color = Color.Black,
                        fontFamily = FontFamily.Cursive,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }



                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {


                    Text(
                        text = if (lesson.teacher.isNullOrBlank()) "" else lesson.teacher,//lesson.teachers[0].name,
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 11.sp,
                        color = Color.DarkGray,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Text(
                        text = if (lesson.audience.isNullOrBlank()) "" else lesson.audience.slice(0..(lesson.audience.length-2)),//lesson.classroom,
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 11.sp,
                        color = Color.DarkGray,
                        fontFamily = FontFamily.SansSerif,
                        modifier = Modifier.padding(horizontal = 5.dp)
                    )
                }



            }

        }
    }



}