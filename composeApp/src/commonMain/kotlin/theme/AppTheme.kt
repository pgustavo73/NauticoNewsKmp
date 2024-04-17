package theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


val appDarkColors = darkColors(
    onBackground = AppColors.Background
)
val appLightColors = lightColors(
    onBackground = AppColors.Background
)

@Composable
fun AppTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = if (isDarkTheme) appDarkColors else appLightColors,
        content = { content() }
    )
}