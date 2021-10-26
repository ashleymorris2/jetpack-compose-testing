package com.avaygo.composetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.avaygo.composetest.ui.theme.ComposeTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloCompose()
        }
    }
}


@Composable
fun HelloCompose() {
    Column(modifier = Modifier
        .background(Color.LightGray)
        .fillMaxHeight(0.5f)
        .width(300.dp)
        .padding(16.dp)
        .border(5.dp, color = Color.Magenta)
        .padding(5.dp)
        .border(5.dp, color = Color.Blue)
    ) {

        Text(text = "Hello", modifier = Modifier.offset(50.dp, 20.dp).clickable {  })
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "World", modifier = Modifier.offset(50.dp, 20.dp))
    }
}

@Composable
fun Greeting(name: String) {

    Column(modifier = Modifier
        .background(Color.Green)
        .width(100.dp)
        .height(300.dp)
        .fillMaxWidth(),
           horizontalAlignment = Alignment.CenterHorizontally,
           verticalArrangement = Arrangement.Bottom) {
        Text(text = "Hello $name!", Modifier.clickable {  })
        Text("I like chicken")
    }

}

