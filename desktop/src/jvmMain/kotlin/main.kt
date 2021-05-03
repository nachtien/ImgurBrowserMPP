import androidx.compose.desktop.Window
import androidx.compose.runtime.rememberCoroutineScope
import com.imgur.browser.homescreen.SearchScreen
import com.imgur.browser.search.SearchGalleryViewModel
import com.imgur.browser.theme.MultiBlendTheme

fun main() = Window {
    MultiBlendTheme {
        SearchScreen(SearchGalleryViewModel(rememberCoroutineScope())) {

        }
    }
}
