package ort.tp3.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ort.tp3.myapplication.ui.navigation.Routes
import ort.tp3.myapplication.ui.theme.poppinsFamily

@Composable
fun SettingsScreen(navController: NavController) {
    var pushEnabled by remember { mutableStateOf(false) }
    var darkModeEnabled by remember { mutableStateOf(false) }

    val brownColor = Color(0xFF9A4D28)
    val backgroundColor = Color(0xFFF8F4F1)
    val headerTextColor = Color(0xFF9EA1A8)

    val customSwitchColors = SwitchDefaults.colors(
        checkedThumbColor = Color.White,
        checkedTrackColor = brownColor,
        uncheckedThumbColor = Color.White,
        uncheckedTrackColor = brownColor,
        uncheckedBorderColor = Color.Transparent
    )

    val fixedThumb: @Composable () -> Unit = {
        Box(
            modifier = Modifier
                .size(24.dp)
                .background(Color.Transparent)
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Account Settings",
            color = headerTextColor,
            fontSize = 18.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        SettingsRow(
            text = "Edit profile",
            onClick = { navController.navigate(Routes.Profile.route) }
        )

        SettingsRow(text = "Change password")

        SettingsRow(text = "Push notifications", hasArrow = false) {
            Switch(
                checked = pushEnabled,
                onCheckedChange = { pushEnabled = it },
                colors = customSwitchColors,
                thumbContent = fixedThumb
            )
        }

        SettingsRow(text = "Dark mode", hasArrow = false) {
            Switch(
                checked = darkModeEnabled,
                onCheckedChange = { darkModeEnabled = it },
                colors = customSwitchColors,
                thumbContent = fixedThumb
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = Color.LightGray.copy(alpha = 0.3f), thickness = 1.dp)
        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "More",
            color = headerTextColor,
            fontSize = 18.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        SettingsRow(text = "About us")
        SettingsRow(text = "Privacy policy")
        SettingsRow(text = "Terms and conditions")

        Spacer(modifier = Modifier.height(120.dp))
    }
}

@Composable
fun SettingsRow(
    text: String,
    hasArrow: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontFamily = poppinsFamily,
            color = Color(0xFF2C1911),
            fontWeight = FontWeight.SemiBold
        )

        if (content != null) {
            content()
        } else if (hasArrow) {
            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = null,
                tint = Color.DarkGray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}