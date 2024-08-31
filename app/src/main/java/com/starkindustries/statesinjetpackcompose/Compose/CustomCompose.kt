package com.starkindustries.statesinjetpackcompose.Compose
import android.graphics.Paint.Align
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.starkindustries.statesinjetpackcompose.R

@Composable
fun TextCompose(text:String,modifier: Modifier){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()) {
        Text(text = text,
            fontStyle = FontStyle.Normal,
            fontSize = 20.sp,
            modifier = modifier
        )
    }
}

@Composable
fun ButtonCompose(){
    val count = rememberSaveable { mutableStateOf(0) }
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(50.dp, 10.dp, 50.dp, 0.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = {
                count.value++
                Log.d("ValueListner", "ButtonClicked")
            },
        ) {
            TextCompose(text = "Send Notification",Modifier)
        }
    }

}

@Composable
fun SentNotificationCompose(count:Int,increment:()->Unit){
Column(modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center) {
    TextCompose(text = "You have sent ${count} notifications",Modifier)
    Button(onClick = {
        increment()
        Log.d("ValueListner","Nudes Send")
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(50.dp, 10.dp, 50.dp, 0.dp)) {
        TextCompose(text = "Send Nudes",Modifier)
    }
}
}

@Composable
fun NotificationCardcompose(value:Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp)
        .padding(10.dp)){
        Row(){
            Image(imageVector = Icons.Outlined.Notifications, contentDescription = "",
                modifier = Modifier
                    .padding(20.dp,10.dp, 0.dp, 0.dp)
                    .size(40.dp))
            TextCompose(text = "Message Sent so far "+value, modifier = Modifier.padding(30.dp,18.dp,60.dp,0.dp).
            fillMaxSize())
        }
    }
}

@Composable
fun CombinationCompose(){
    val count = rememberSaveable { mutableStateOf(0) }
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxHeight()) {
        SentNotificationCompose(count.value,{count.value++})
        NotificationCardcompose(count.value)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewFunction(){


}