package com.imgur.browser

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.imgur.browser.theme.MultiBlendTheme
import com.imgur.browser.NavGraph

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiBlendTheme {
                NavGraph()
            }
        }
    }
}
