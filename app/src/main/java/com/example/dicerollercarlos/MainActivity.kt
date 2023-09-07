package com.example.dicerollercarlos

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dicerollercarlos.ui.theme.DiceRollerCarlosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerCarlosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting(Android)
                    DiceRollerApp()
                }
            }
        }
    }
}
@Preview
@Composable
fun DiceRollerApp() {
    DiceWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {

    var resultDado1 by remember{ mutableStateOf(1) }
    var resultDado2 by remember{ mutableStateOf(6) }


    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = getRandomDiceImg(resultDado1)), contentDescription = stringResource(
            R.string.image_cara_1
        ) )
        Spacer(modifier = Modifier.height(16.dp));

        Image(painter = painterResource(id = getRandomDiceImg(resultDado2)), contentDescription = stringResource(
            R.string.image_cara_1
        ) )

        Button(onClick = {
            resultDado1 = (1..6).random()
            resultDado2 =(1..6).random()
            Log.d("NumAlea", "Valor aleatorio")
        }) {
            Text(text = stringResource(R.string.btn_roller))
        }
    }
}

private fun getRandomDiceImg(valor: Int):Int{
    val imagesResource = when(valor){
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    return  imagesResource
}
