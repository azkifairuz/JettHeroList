package com.azkifairuz.jetherolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.azkifairuz.jetherolist.model.HeroesData
import com.azkifairuz.jetherolist.ui.theme.JetHeroListTheme

@Composable
fun JetHeroesApp(
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier) {
        LazyColumn{
            items(HeroesData.heroes,key = {it.id}){hero ->
                HeroListItem(
                    name = hero.name,
                    photoUrl = hero.photoUrl,
                    )
            }
        }
    }
}

@Composable
fun HeroListItem(
    name:String,
    photoUrl:String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.clickable {  }
    ) {
        AsyncImage(
            model = photoUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .padding(8.dp)
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Medium,
            modifier = modifier
                .weight(1f)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun HeroListItemPreview() {
    JetHeroListTheme {
        HeroListItem(
            name = "H.O.S. Cokroaminoto",
            photoUrl = "https://raw.githubusercontent.com/dicodingacademy/assets/main/android_compose_academy/pahlawan/6.jpg"
        )
    }
}
@Preview(showBackground = true)
@Composable
fun JetHeroesAppPreview() {
    JetHeroListTheme {
        JetHeroesApp()
    }
}

