package upc.edu.superherocompose.ui.herodetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import upc.edu.superherocompose.data.model.Hero
import upc.edu.superherocompose.repository.HeroRepository

@Composable
fun HeroDetail(id: String = "500") {
    val repository = HeroRepository()
    val hero = remember{
        mutableStateOf<Hero?>(null)
    }
    repository.searchById(id){
         hero.value = it.data!!
    }

    if(hero.value != null){
        Column() {
            GlideImage(
                imageModel = { hero.value!!.image.url},
                imageOptions = ImageOptions(contentScale = ContentScale.Fit),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
            )


        }

    }
}