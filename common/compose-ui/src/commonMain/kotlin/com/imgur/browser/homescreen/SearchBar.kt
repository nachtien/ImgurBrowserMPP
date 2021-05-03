package imgur.ui.searchscreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.imgur.browser.search.SearchGalleryViewModel

@Composable
private fun SearchBarComponent(text: String = "", onValueChange: (String) -> Unit = {}) {
    TopAppBar(
        modifier = Modifier.height(60.dp),
        title = {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                leadingIcon = { Icon(Icons.Filled.Search, null) },
                onValueChange = onValueChange,
                placeholder = { Text("Search") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.White,
                    placeholderColor = Color(1, 1, 1, 153),
                    cursorColor = Color.White,
                ),
                textStyle = TextStyle(color = Color.White),
                keyboardOptions = KeyboardOptions(autoCorrect = false, imeAction = ImeAction.Search)
            )
        }
    )
}

@Composable
fun SearchBar(viewModel: SearchGalleryViewModel) {
    var text by rememberSaveable { mutableStateOf("") }

    SearchBarComponent(text) { value ->
        text = value
        viewModel.searchGalleries(value)
    }
}
