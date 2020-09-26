package me.moallemi.kmpshowcase.server

import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.routing.routing
import io.ktor.serialization.json

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@JvmOverloads
fun Application.module(testing: Boolean = false) {

    install(ContentNegotiation) {
        json()
    }

    install(CORS) {
        corsAllowedHosts.onEach { allowedHost ->
            host(host = allowedHost, schemes = listOf("http", "https"))
        }
    }

    routing {
        home()
        apiV1()
        static("/") {
            resources("")
        }
    }
}