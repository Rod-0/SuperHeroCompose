package upc.edu.superherocompose.ui.herolist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

import upc.edu.superherocompose.data.model.Hero

@Composable
fun HeroList(heroes: MutableState<List<Hero>>) {
    LazyColumn(content = {
        items(heroes.value) {
            HeroRow(it)
        }
    })

}

@Composable
fun HeroRow(hero: Hero) {
    Card {
        Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
            HeroImage(hero.image.url)
            Column {
                Text(text = hero.name)
                Text(text = hero.biography.fullName)
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