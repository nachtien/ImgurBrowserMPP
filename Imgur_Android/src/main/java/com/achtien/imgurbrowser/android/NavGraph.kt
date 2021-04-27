package me.nickachtien.androidApp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import me.nickachtien.androidApp.MainDestinations.DETAIL_SCREEN
import me.nickachtien.androidApp.MainDestinations.GALLERY_ID_KEY
import com.achtien.imgurbrowser.android.ui.galleryscreen.GalleryScreen
import com.achtien.imgurbrowser.android.ui.searchscreen.SearchScreen

object MainDestinations {
    const val SEARCH_SCREEN = "search"
    const val DETAIL_SCREEN = "details"
    const val GALLERY_ID_KEY = "galleryid"
}

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = MainDestinations.SEARCH_SCREEN,
) {

    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.SEARCH_SCREEN) { backstackEntry ->
            SearchScreen {
                actions.openGallery(it, backstackEntry)
            }
        }
        composable(
            "${DETAIL_SCREEN}/{$GALLERY_ID_KEY}",
            arguments = listOf(
                navArgument(GALLERY_ID_KEY) { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val galleryId = requireNotNull(backStackEntry.arguments?.getString(GALLERY_ID_KEY))
            GalleryScreen(galleryId = galleryId, upPress = {
                actions.upPress(backStackEntry)
            })
        }
    }
}

class MainActions(navController: NavHostController) {
    val openGallery = { galleryId: String, from: NavBackStackEntry ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigate("$DETAIL_SCREEN/$galleryId")
        }
    }

    val upPress: (rom: NavBackStackEntry) -> Unit = { from ->
        // In order to discard duplicated navigation events, we check the Lifecycle
        if (from.lifecycleIsResumed()) {
            navController.navigateUp()
        }
    }
}

private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED