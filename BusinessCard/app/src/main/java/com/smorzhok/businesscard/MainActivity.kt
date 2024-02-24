package com.smorzhok.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.smorzhok.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardImage(
                        "Vlada",
                        "+7-904-888-88-88",
                        "vsmorzhok@mail.ru",
                        "vladryanka"
                    )
                }
            }
        }
    }
}

@Composable
fun CardImage(
    name: String,
    phoneNumber: String,
    mail: String,
    id: String,
    modifier: Modifier = Modifier
) {
    val image = painterResource(R.drawable.android_logo)
    val phoneImg = painterResource(R.drawable.phone)
    val mailImg = painterResource(R.drawable.mail)
    val idImg = painterResource(R.drawable.id)


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.size(256.dp),
            alpha = 0.5F
        )
        CardText(
            name = name,
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(8.dp)
        )
        CardText(
            name = "Android Developer Extraordinaire",
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .padding(8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Image(
                painter = phoneImg,
                contentDescription = null,
                modifier = Modifier.size(64.dp).padding(16.dp),
                alpha = 0.5F
            )
            CardText(
                name = phoneNumber,

                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Image(
                painter = mailImg,
                contentDescription = null,
                modifier = Modifier.size(64.dp).padding(16.dp),
                alpha = 0.5F
            )
            CardText(
                name = mail,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Image(
                painter = idImg,
                contentDescription = null,
                modifier = Modifier.size(64.dp).padding(16.dp),
                alpha = 0.5F
            )
            CardText(
                name = id,
                modifier = Modifier
                    .padding(8.dp)
            )
        }
    }

}

@Composable
fun CardText(name: String, modifier: Modifier = Modifier) {

    Text(text = "$name", textAlign = TextAlign.Center,
        fontSize = 30.sp)
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        CardImage(
            "Vladislava Smorzhok",
            "+7-904-888-88-88",
            "vsmorzhok@mail.ru",
            "vladryanka"
        )
    }
}