package com.charan.themeify.presentation.feature_dynamic_theme

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charan.themeify.data.ThemeConfig
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch
import org.json.JSONObject
import androidx.core.graphics.toColorInt

class DynamicThemeViewModel : ViewModel() {

    var themeConfig by mutableStateOf(ThemeConfig())

    private val generativeModel by lazy {
        GenerativeModel(
            modelName = "gemini-1.5-flash",
            apiKey = ""
        )

    }

    fun processUserInput(userQuery: String) {
        viewModelScope.launch {
            val aiResponse = getAiResponse(userQuery)
            parseAiResponse(aiResponse)
        }
    }

    private suspend fun getAiResponse(userQuery: String): String {
        val prompt = """
            You are an assistant for an Android app. Parse user instructions like "change app color to red", "change text color to black", "change background color to white", "increase font size", or "switch to dark mode".
            Only respond with a JSON key-value like:

            - {"THEME_COLOR": "#FF0000"}
            - {"TEXT_COLOR": "#000000"}
            - {"BACKGROUND_COLOR": "#ffffff"}
            - {"FONT_SIZE": "Increase"}
            - {"THEME_MODE": "dark"}

            No explanations, just return the JSON key-value pair. Not as markdown, just a single JSON key value pair as string, that too without \n or other escape sequences.

            Query: $userQuery
        """.trimIndent()

        val response = generativeModel.generateContent(prompt)
        return response.text ?: "No response"
    }

    private fun parseAiResponse(aiResponse: String) {
        try {
            val unescaped = JSONObject("""{"data": $aiResponse}""").getString("data")

            val jsonObject = JSONObject(unescaped)
            when {
                jsonObject.has("THEME_COLOR") -> {
                    val themeColor = jsonObject.getString("THEME_COLOR")
                    // Apply the theme color to the app
                    Log.d("RES", "parseAiResponse: themeColor: $themeColor")
                    setPrimaryColor(color = Color(themeColor.toColorInt()))
                }

                jsonObject.has("TEXT_COLOR") -> {
                    val textColor = jsonObject.getString("TEXT_COLOR")
                    // Apply the theme color to the app
                    Log.d("RES", "parseAiResponse: textColor: $textColor")
                    setTextColor(color = Color(textColor.toColorInt()))
                }

                jsonObject.has("BACKGROUND_COLOR") -> {
                    val backgroundColor = jsonObject.getString("BACKGROUND_COLOR")
                    // Apply the theme color to the app
                    Log.d("RES", "parseAiResponse: backgroundColor: $backgroundColor")
                    setBackgroundColor(color = Color(backgroundColor.toColorInt()))
                }

                jsonObject.has("FONT_SIZE") -> {
                    val fontSize = jsonObject.getString("FONT_SIZE")
                    // Apply the font size to the app
                    Log.d("RES", "parseAiResponse: fontSize: $fontSize")
                }

                jsonObject.has("THEME_MODE") -> {
                    val themeMode = jsonObject.getString("THEME_MODE")
                    // Apply the font size to the app
                    Log.d("RES", "parseAiResponse: themeMode: $themeMode")
                    toggleDarkMode(isDarkMode = themeMode == "dark")
                }
            }
        } catch (_: Exception) {
            Log.e("ParsingError", "Invalid JSON from Gemini")
        }
    }

    private fun toggleDarkMode(isDarkMode: Boolean) {
       themeConfig = themeConfig.copy(isDarkTheme = isDarkMode)
    }

    private fun setPrimaryColor(color: Color) {
        themeConfig = themeConfig.copy(primaryColor = color)
    }

    private fun setTextColor(color: Color) {
        themeConfig = themeConfig.copy(textColor = color)
    }

    private fun setBackgroundColor(color: Color) {
        themeConfig = themeConfig.copy(backgroundColor = color)
    }

    private fun changeFontSize() {

    }
}