package dev.abd3lraouf.blackscreenrepro

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.commit
import dev.abd3lraouf.blackscreenrepro.ui.theme.BlackScreenReproTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlackScreenReproTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ContainerFragmentView()
                }
            }
        }
    }
}

@Composable
fun ContainerFragmentView() {
    AndroidView(factory = { context ->
        FragmentContainerView(context).apply {
            id = View.generateViewId()
            (context as MainActivity).supportFragmentManager.commit {
                setReorderingAllowed(true)
                add(id, ContainerFragment())
            }
        }
    }, modifier = Modifier.fillMaxSize())
}