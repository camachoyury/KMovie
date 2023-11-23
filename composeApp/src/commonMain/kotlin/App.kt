import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.camachoyury.kmovie.Injector
import com.camachoyury.kmovie.android.composables.KToolBar
import com.camachoyury.kmovie.view.HomeScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class, ExperimentalFoundationApi::class)
@Composable
fun App() {
    MaterialTheme {
        val topBarState = remember { mutableStateOf(true) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            val scope = rememberCoroutineScope()

            val homeViewModel = Injector.homeViewModel

            homeViewModel.loadItems(scope)
            Scaffold(

                content = { padding ->

                    HomeScreen(homeViewModel)
                },
                topBar = {
                    KToolBar(

                        topBarState
                    ) { Text("KMovie ") }
                }
            )
        }
//        var greetingText by remember { mutableStateOf("Hello World!") }
//        var showImage by remember { mutableStateOf(false) }
//        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
//            Button(onClick = {
//                greetingText = "Compose: ${Greeting().greet()}"
//                showImage = !showImage
//            }) {
//                Text(greetingText)
//            }
//            AnimatedVisibility(showImage) {
//                Image(
//                    painterResource("compose-multiplatform.xml"),
//                    null
//                )
//            }
//        }
    }
}