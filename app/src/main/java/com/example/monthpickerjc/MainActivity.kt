package com.example.monthpickerjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.monthpickerjc.ui.theme.MonthPickerJCTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MonthPickerJCTheme {

                var visible by remember {
                    mutableStateOf(true)
                }

                var date by remember {
                    mutableStateOf("")
                }

                val currentMonth = Calendar.getInstance().get(Calendar.MONTH)
                val year = Calendar.getInstance().get(Calendar.YEAR)

                // A surface container using the 'background' color from the theme
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    MonthPicker(
                        visible = visible,
                        currentMonth = currentMonth,
                        currentYear = year,
                        confirmButtonCLicked = { month_, year_ ->
                            date = "$month_/$year_"
                            visible = false
                        },
                        cancelClicked = {
                            visible = false
                        }
                    )

                    Text(
                        text = date,
                        modifier = Modifier
                            .clickable { visible = true }
                    )

                }
            }
        }
    }
}
