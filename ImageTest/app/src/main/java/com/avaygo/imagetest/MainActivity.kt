package com.avaygo.imagetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val painter = painterResource(id = R.drawable.candle_front)
            val description = "A candle"
            val title = "A candle that smells nice"

            ImageCard(painter = painter,
                      contentDescription = description,
                      title = title)

//            val scaffoldState = rememberScaffoldState()
//            var textFieldState by remember {
//                mutableStateOf("")
//            }
//            val scope = rememberCoroutineScope()
//
//            Scaffold(modifier = Modifier.fillMaxSize(),
//                     scaffoldState = scaffoldState) {
//
//                Column(horizontalAlignment = Alignment.CenterHorizontally,
//                       verticalArrangement = Arrangement.Center, modifier = Modifier
//                        .fillMaxSize()
//                        .padding(30.dp)) {
//
//                    TextField(value = textFieldState,
//                              label = { Text("Enter name") },
//                              onValueChange = {
//                                  textFieldState = it
//                              },
//                              singleLine = true,
//                              modifier = Modifier.fillMaxWidth())
//
//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
//
//                        Button(onClick = {
//                            scope.launch {
//                                scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
//                            }
//                        }, content = {
//                            Text(text = "Say Hi")
//                        })
//                    }
//
//
//                }
//
//            }

        }
    }

    @Composable
    fun ImageCard(
            painter: Painter,
            contentDescription: String,
            title: String,
            modifier: Modifier = Modifier
    ) {

        val color = remember {
            mutableStateOf(Color.Blue)
        }

        Card(modifier =
             modifier
                 .fillMaxWidth()
                 .clickable { color.value = Color(Random.nextFloat(), Random.nextFloat(), Random.nextFloat()) },
             shape = RoundedCornerShape(15.dp),
             elevation = 5.dp) {

            Box(modifier = Modifier.height(200.dp)) {
                Image(
                    painter = painter,
                    contentDescription = contentDescription,
                    contentScale = ContentScale.Crop)

                Box(modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                color.value,
                                Color.Black),
                            startY = 300f)))

                Box(modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                    contentAlignment = Alignment.BottomStart) {

                    Text(title,
                         style = TextStyle(color = Color.White,
                                           fontSize = 16.sp,
                                           fontFamily = FontFamily(Font(R.font.lexend_regular))))
                }
            }

        }

    }


    @Preview
    @Composable
    fun Preview() {
        ImageCard(painter = painterResource(id = R.drawable.candle_front),
                  contentDescription = "Hello",
                  title = "Hello sexy chops")
    }

}