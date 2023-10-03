package dev.tomoya0x00.composeissuedemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import dev.tomoya0x00.composeissuedemo.ui.theme.ComposeIssueDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeIssueDemoTheme {
                val infiniteTransition = rememberInfiniteTransition(label = "")
                val boxHeightFraction by infiniteTransition.animateFloat(
                    initialValue = 0.25f,
                    targetValue = 0.5f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(1000, easing = LinearEasing),
                        repeatMode = RepeatMode.Reverse
                    ),
                    label = "",
                )
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Cyan,
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Box(
                            modifier = Modifier
                                .align(Alignment.Center)
                                .background(Color.Green)
                                .fillMaxWidth()
                                .fillMaxHeight(boxHeightFraction)
                        )

                        val context = LocalContext.current
                        Button(
                            modifier = Modifier
                                .align(Alignment.Center),
                            onClick = {
                                context.startActivity(
                                    Intent(context, ModalActivity::class.java)
                                )
                            }
                        ) {
                            Text("Launch ModalActivity")
                        }
                    }
                }
            }
        }
    }
}
