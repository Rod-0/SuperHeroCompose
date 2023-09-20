package upc.edu.superherocompose.ui.herolist

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import upc.edu.superherocompose.data.model.Hero
import upc.edu.superherocompose.repository.HeroRepository
import upc.edu.superherocompose.utils.Result

@Composable
fun Search() {

    val textQuery = remember {
        mutableStateOf("")
    }

    val heroes = remember {
        mutableStateOf(listOf<Hero>())
    }

    Column {
        HeroSearch(textQuery, heroes)
        HeroList(heroes)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroSearch(textQuery: MutableState<String>, heroes: MutableState<List<Hero>>) {

    val repository = HeroRepository()
    val context = LocalContext.current
    OutlinedTextField(
        value = textQuery.value,
        onValueChange = {
            textQuery.value = it
        },
        leadingIcon = {
            Icon(Icons.Filled.Search, contentDescription = null)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Search
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                repository.searchHeroes(textQuery.value) {
                    if (it is Result.Success) {
                        heroes.value = it.data!!
                    } else {
                        Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()

                    }


                }
            }
        )
    )

}

