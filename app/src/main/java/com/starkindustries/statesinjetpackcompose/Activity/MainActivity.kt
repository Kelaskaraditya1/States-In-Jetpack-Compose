package com.starkindustries.statesinjetpackcompose.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.starkindustries.statesinjetpackcompose.Compose.CombinationCompose
import com.starkindustries.statesinjetpackcompose.Compose.SentNotificationCompose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CombinationCompose()
        }
    }
}
