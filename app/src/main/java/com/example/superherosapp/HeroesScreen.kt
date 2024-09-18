package com.example.superherosapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superherosapp.data.Hero
import com.example.superherosapp.model.hero.HeroesRepository
import com.example.superherosapp.model.hero.HeroesRepository.heroes
import com.example.superherosapp.ui.theme.SuperheroesTheme

@Preview
@Composable
fun HeroListPreview() {
    SuperheroesTheme{
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            HeroesList(modifier = Modifier.padding(innerPadding))
        }
    }
}
@Composable
fun HeroesList(modifier: Modifier = Modifier) {
    LazyColumn (modifier=modifier, horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(18.dp)) {
        items(heroes){
            HeroCard(item = it)
        }
    }
}
@Composable
fun HeroCard(modifier: Modifier = Modifier, item:Hero){
    Card (modifier = modifier) {
        Row(modifier = Modifier.padding(16.dp)) {
            Column (verticalArrangement = Arrangement.SpaceAround ) {
                Text(text = stringResource(id = item.nameRes), style = MaterialTheme.typography.displayLarge)
                Text(text = stringResource(id = item.descriptionRes), style = MaterialTheme.typography.bodySmall)

            }

        }
    }
}