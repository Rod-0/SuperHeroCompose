package upc.edu.superherocompose.ui.herodetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.superherocompose.data.model.Hero
import upc.edu.superherocompose.repository.HeroRepository

@Composable
fun HeroDetail(id: String) {
    val repository = HeroRepository()
    val hero = remember {
        mutableStateOf<Hero?>(null)
    }
    repository.searchById(id) {
        hero.value = it.data!!
    }

    if (hero.value != null) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.height(64.dp))
            GlideImage(
                imageModel = { hero.value!!.image.url },
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier
                    .fillMaxWidth()
                    .size(300.dp)
                    .clip(shape = RoundedCornerShape(8.dp))
            )
            HeroHeader(name = hero.value!!.name)
            Spacer(modifier = Modifier.height(64.dp))
            HeroBiography(hero = hero.value!!)
            Spacer(modifier = Modifier.height(64.dp))
            HeroPowerStats(hero = hero.value!!)
            


        }

    }
}

@Composable
fun HeroHeader(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun HeroBiography(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Column {
            Text(
                text = "Biography",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
            Text(text = "Full Name: "+ hero.biography.fullName,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = "Birth Place: " + hero.biography.birthplace,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = "Publisher: " + hero.biography.publisher,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }

    }

}


@Composable
fun HeroPowerStats(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    ) {
        Column {

            Text(
                text = "Power Stats",
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(8.dp)
            )
            Text(text = "Intelligence: "+ hero.powerStats.intelligence,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = "Strength: " + hero.powerStats.strength,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = "Speed: " + hero.powerStats.speed,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = "Durability: " + hero.powerStats.durability,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = "Power: " + hero.powerStats.power,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )

            Text(text = "Combat: " + hero.powerStats.combat,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(8.dp)
            )
        }

    }

}