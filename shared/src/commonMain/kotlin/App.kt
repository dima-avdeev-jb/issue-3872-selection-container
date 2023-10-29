import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import org.jetbrains.compose.resources.ExperimentalResourceApi

@Composable
fun App() {
    Column {

        Text("Text not in selection container. Meets expectation of default cursor.")

        SelectionContainer {
            Text("Text in selection container. Meets expectation of text input cursor.")
        }

        Text(
            "Text not in selection container, with hand cursor modifier. Meets expectation of hand cursor.",
            modifier = Modifier.pointerHoverIcon(
                PointerIcon.Hand
            )
        )

        SelectionContainer {
            Text(
                "Text in selection container, with hand cursor. Does NOT meet expectation. Because the Text is the child of SelectionContainer, we expect the cursor of the child to override the parent. Therefore, we expect a hand cursor here. However, we get a text input cursor.",
                modifier = Modifier.pointerHoverIcon(
                    PointerIcon.Hand
                )
            )
        }
    }
}

expect fun getPlatformName(): String