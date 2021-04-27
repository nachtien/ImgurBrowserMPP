package com.achtien.imgurbrowser.android.ui.searchscreen

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import me.nickachtien.androidApp.NavGraph
import com.achtien.imgurbrowser.android.ui.theme.MultiBlendTheme

class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiBlendTheme {
                NavGraph()
            }
        }
    }
}
