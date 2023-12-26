package com.example.businesscardapp

import android.os.Bundle
import android.os.ParcelFileDescriptor
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import androidx.compose.material3.Icon
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp()
{

    Surface(color = Color(0xFFEADDFF)) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(top = 170.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally)
        {BusinessCardHead(
            fullname = stringResource(R.string.fullname),
            description = stringResource(R.string.desc),
            imagePainter = painterResource(R.drawable.android_logo)
        )
            BusinessCardInfo(pno = stringResource(R.string.pno),
                sname = stringResource(R.string.snm) ,
                mailname = stringResource(R.string.email)
            )}
    }
}
@Composable
private fun BusinessCardHead(
    imagePainter: Painter,
    modifier: Modifier = Modifier,
    fullname:String,
    description:String
)
{
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = CenterHorizontally)
    {
        Surface(color = Color(21, 37, 124, 255)) {
            Image(painter = imagePainter, contentDescription = null, Modifier.size(90.dp, 90.dp))
        }
        Text(text = fullname, fontWeight = FontWeight.Bold,modifier= Modifier.padding(top = 24.dp, bottom = 8.dp, start = 5.dp,end=5.dp),
            fontSize = 30.sp)
        Text(text = description, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}
@Composable
private fun  BusinessCardInfo(
    pno:String,
    sname:String,
    mailname:String,
    modifier: Modifier = Modifier,
)
{
    Column(modifier= Modifier
        .padding(80.dp)
        .fillMaxHeight()
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start)
    {
        Row (horizontalArrangement = Arrangement.Absolute.Left,modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Default.Call, contentDescription = "PhoneNo")
            Text(text = pno, fontSize = 15.sp,modifier= Modifier.padding(start = 5.dp))

        }
        Row (horizontalArrangement = Arrangement.Absolute.Left, modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Default.Share, contentDescription = "Shareit")
            Text(text = sname, fontSize = 15.sp,modifier= Modifier.padding(start = 5.dp))

        }
        Row (horizontalArrangement = Arrangement.Absolute.Left,modifier = Modifier.fillMaxWidth()){
            Icon(imageVector = Icons.Default.Email, contentDescription = "Email")
            Text(text = mailname, fontSize = 15.sp,modifier= Modifier.padding(start = 5.dp))

        }
    }
}







@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}