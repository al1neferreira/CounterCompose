package com.example.countercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.countercompose.ui.theme.CounterComposeTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<CounterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CounterComposeTheme {
                ClickCount(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun ClickCount(
    viewModel: CounterViewModel
) {
    var count by remember { mutableIntStateOf(viewModel.getCount()) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = 34.sp,
            text = count.toString(),
        )
        Spacer(modifier = Modifier.size(10.dp))

        Button(onClick = {
            viewModel.increment()
            count = viewModel.getCount()
        }) {
            Text(text = "Increment")
        }

    }

}
