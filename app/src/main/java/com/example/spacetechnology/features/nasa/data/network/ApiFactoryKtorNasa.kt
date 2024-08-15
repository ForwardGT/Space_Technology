package com.example.spacetechnology.features.nasa.data.network

import com.example.spacetechnology.core.utils.API_KEY_NASA
import com.example.spacetechnology.core.utils.BASE_URL_NASA
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object ApiFactoryKtorNasa {

    val client = HttpClient(CIO) {
        expectSuccess = true

        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
        install(Logging) {
            logger = Logger.ANDROID
            level = LogLevel.BODY
        }
        install(DefaultRequest) {
            url {
                host = BASE_URL_NASA
                parameters.append("api_key", API_KEY_NASA)
            }
        }
    }
}