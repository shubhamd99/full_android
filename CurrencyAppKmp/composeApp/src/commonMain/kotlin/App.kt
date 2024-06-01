import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview
import ui.theme.darkScheme
import ui.theme.lightScheme


@Composable
@Preview
fun App() {
    val colors = if(!isSystemInDarkTheme()) lightScheme else darkScheme

    MaterialTheme(colorScheme = colors) {

    }
}