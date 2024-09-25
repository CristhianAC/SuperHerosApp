package com.example.superherosapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MovableContent
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
            HeroesList(contentPadding = innerPadding)
        }
    }
}
@Preview
@Composable
fun HeroesList(modifier: Modifier = Modifier, contentPadding: PaddingValues = PaddingValues(0.dp)) {
    LazyColumn (modifier=modifier.padding(
        horizontal = 16.dp
    ), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(18.dp)) {
        items(heroes){
            HeroCard(item = it, modifier = Modifier.fillMaxWidth())
        }
    }
}
@Composable
fun HeroCard(modifier: Modifier = Modifier, item:Hero){
    Card (modifier = modifier, elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),) {
        Row(modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
            .sizeIn(minHeight = 72.dp)) {
            Column (verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.weight(1f) ) {
                Text(text = stringResource(id = item.nameRes), style = MaterialTheme.typography.displayLarge)
                Text(text = stringResource(id = item.descriptionRes), style = MaterialTheme.typography.bodySmall)

            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(modifier = Modifier
                .size(72.dp)
                .clip(RoundedCornerShape(8.dp))
            ){
            Image(painter = painterResource(id = item.imageRes), contentDescription = stringResource(
                id = item.nameRes
            ), alignment = Alignment.TopCenter,
                contentScale = ContentScale.FillWidth
            )
            }
        }
    }
}