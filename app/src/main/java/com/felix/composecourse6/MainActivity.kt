package com.felix.composecourse6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.felix.composecourse6.ui.theme.ComposeCourse6Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourse6Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtworkSpace()
                }
            }
        }
    }
}

@Composable
fun ArtworkSpace() {
    var counter by remember {
        mutableStateOf(1)
    }

    val image = when (counter) {
        1 -> R.drawable.maine
        2 -> R.drawable.shasta
        else -> R.drawable.moraine
    }
    val title = when (counter) {
        1 -> "Autumn in Maine"
        2 -> "Mt Shasta"
        else -> "Moraine Lake, Alberta"
    }
    val desc = when (counter) {
        1 -> "youngcadadia22"
        2 -> "valledweller33"
        else -> "Hwanderer8"
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(240.dp)
                .height(320.dp)
        )
        Spacer(
            modifier = Modifier.padding(16.dp)
        )
        Card(
            modifier = Modifier.padding(16.dp)
        ) {
            Column {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
                Text(
                    text = desc,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    when (counter) {
                        1 -> {
                            counter = 3
                        }
                        2 -> {
                            counter = 1
                        }
                        else -> {
                            counter = 2
                        }
                    }
                },
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = {
                    when (counter) {
                        1 -> {
                            counter = 2
                        }
                        2 -> {
                            counter = 3
                        }
                        else -> {
                            counter = 1
                        }
                    }
                },
                contentPadding = PaddingValues(8.dp),
            ) {
                Text(text = "Next")
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ArtworkSpacePreview() {
    ComposeCourse6Theme {
        ArtworkSpace()
    }
}

