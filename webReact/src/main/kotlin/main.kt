import kotlinx.browser.document
import me.moallemi.kmpshowcase.shared.di.initKoinJs
import react.dom.render
import react.child
import styled.injectGlobal

fun main() {
    initKoinJs()
    injectGlobal(Styles.global)
    val app = Application()
    render(document.getElementById("root")) {
        child(app.createRootComponent())
    }
}