package upc.edu.superherocompose.ui.herolist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

import upc.edu.superherocompose.data.model.Hero

@Composable
fun HeroList(heroes: MutableState<List<Hero>>, selectHero:(String)->Unit) {
    LazyColumn(content = {
        items(heroes.value) {
            HeroRow(it, selectHero)
        }
    })

}

@Composable
fun HeroRow(hero: Hero, selectHero:(String)->Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
        .clickable {
            selectHero(hero.id)
        }) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            HeroImage(hero.image.url)
            Column(modifier = Modifier.weight(5f)) {
                Text(text = hero.name, fontWeight = FontWeight.Bold)
                Text(text = hero.biography.fullName)
            }
            IconButton(modifier= Modifier.weight(1f),onClick = {}) {
                Icon(Icons.Default.Favorite, contentDescription = null)

            }
        }



    }
}

@Composable
fun HeroImage(url: String) {
    GlideImage(
        imageModel = { url },
        imageOptions = ImageOptions(contentScale = ContentScale.Fit),
        modifier = Modifier.size(92.dp)
    )
}