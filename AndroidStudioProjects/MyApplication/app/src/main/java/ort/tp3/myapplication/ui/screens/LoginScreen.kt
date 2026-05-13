package ort.tp3.myapplication.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ort.tp3.myapplication.R
import ort.tp3.myapplication.ui.components.AuthTextField
import ort.tp3.myapplication.ui.components.PrimaryButton
import ort.tp3.myapplication.ui.components.SocialIcon

@Composable
fun LoginScreen(
    onNavigateToRegister: () -> Unit = {},
    onLoginSuccess: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isEmailValid by remember(email) {
        derivedStateOf {
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }

    val poppinsSemiBold = FontFamily(Font(R.font.poppins_semibold))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(80.dp))

        Text(
            text = "Login here",
            fontSize = 30.sp,
            fontFamily = poppinsSemiBold,
            color = Color(0xFF1F41BB)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Welcome back you’ve\nbeen missed!",
            fontSize = 20.sp,
            fontFamily = poppinsSemiBold,
            textAlign = TextAlign.Center,
            lineHeight = 28.sp
        )

        AuthTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
            isError = email.isNotEmpty() && !isEmailValid,
            imeAction = ImeAction.Next
        )

        if (email.isNotEmpty() && !isEmailValid) {
            Text(
                text = "Formato de email inválido",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        AuthTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            isPassword = true,
            imeAction = ImeAction.Done
        )

        Box(modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = {  },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Text(
                    text = "Forgot your password?",
                    color = Color(0xFF1F41BB),
                    fontFamily = poppinsSemiBold,
                    fontSize = 14.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        PrimaryButton(
            text = "Sign in",
            onClick = {
                if (isEmailValid && email.isNotEmpty()) {
                    onLoginSuccess()
                }
            },
            enabled = isEmailValid && email.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(30.dp))

        TextButton(onClick = onNavigateToRegister) {
            Text(
                text = "Create new account",
                fontFamily = poppinsSemiBold,
                color = Color(0xFF494949),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Or continue with",
            color = Color(0xFF1F41BB),
            fontFamily = poppinsSemiBold,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SocialIcon(iconRes = R.drawable.ic_google)
            SocialIcon(iconRes = R.drawable.ic_facebook)
            SocialIcon(iconRes = R.drawable.ic_apple)
        }
    }
}