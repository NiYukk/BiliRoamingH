package me.iacn.biliroaming.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

suspend fun fetchJson(url: URL) = withContext(Dispatchers.IO) {
    try {
        JSONObject(url.readText())
    } catch (e: Throwable) {
        null
    }
}

@Suppress("BlockingMethodInNonBlockingContext") // Fuck JetBrain
suspend fun fetchJson(url: String) = fetchJson(URL(url))

suspend fun fetchJsonArray(url: URL) = withContext(Dispatchers.IO) {
    try {
        JSONArray(url.readText())
    } catch (e: Throwable) {
        null
    }
}

@Suppress("BlockingMethodInNonBlockingContext") // Fuck JetBrain
suspend fun fetchJsonArray(url: String) = fetchJsonArray(URL(url))
