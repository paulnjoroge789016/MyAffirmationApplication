package com.example.myaffirmationapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myaffirmationapplication.data.Datasource
import com.example.myaffirmationapplication.model.Affirmation
import com.example.myaffirmationapplication.ui.theme.MyAffirmationApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAffirmationApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AffirmationList(affirmationList = Datasource().loadAffirmations())
                }
            }
        }
    }
}

@Composable
fun AffirmationCard(affirmation: Affirmation, modifier: Modifier = Modifier){
    Card(modifier = modifier.padding(8.dp), elevation = 4.dp) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = affirmation.imageRsc),
                contentDescription = stringResource(id = affirmation.stringRsc),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop

            )

            Text(text = stringResource(id = affirmation.stringRsc),
                modifier = Modifier.padding(10.dp),
                style = MaterialTheme.typography.h6
                )

        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>){
    LazyColumn{
        items(affirmationList){ affirmation ->
            AffirmationCard(affirmation)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAffirmationApplicationTheme {
        AffirmationCard(affirmation = Affirmation(R.string.affirmation2, R.drawable.image2))
    }
}