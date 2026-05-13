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
fun RegisterScreen(
    onNavigateToLogin: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {}
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    val isEmailValid by remember(email) {
        derivedStateOf {
            android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }
    }

    val passwordsMatch = password == confirmPassword && password.isNotEmpty()

    val poppinsSemiBold = FontFamily(Font(R.font.poppins_semibold))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "Create Account",
            fontSize = 30.sp,
            fontFamily = poppinsSemiBold,
            color = Color(0xFF1F41BB)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Create an account so you can explore all the existing jobs",
            fontSize = 14.sp,
            fontFamily = poppinsSemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 20.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        AuthTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = "Email",
            isError = email.isNotEmpty() && !isEmailValid,
            imeAction = ImeAction.Next
        )

        if (email.isNotEmpty() && !isEmailValid) {
            Text(
                text = "Formato de email incorrecto",
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        AuthTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = "Password",
            isPassword = true,
            imeAction = ImeAction.Next
        )

        Spacer(modifier = Modifier.height(20.dp))

        AuthTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            placeholder = "Confirm Password",
            isPassword = true,
            isError = confirmPassword.isNotEmpty() && !passwordsMatch,
            imeAction = ImeAction.Done
        )

        Spacer(modifier = Modifier.height(50.dp))


        PrimaryButton(
            text = "Sign up",
            onClick = { if (isEmailValid && passwordsMatch) onRegisterSuccess() },
            enabled = isEmailValid && passwordsMatch && email.isNotEmpty()
        )

        Spacer(modifier = Modifier.height(30.dp))

        TextButton(onClick = onNavigateToLogin) {
            Text(
                text = "Already have an account",
                fontFamily = poppinsSemiBold,
                color = Color(0xFF494949),
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Or continue with",
            color = Color(0xFF1F41BB),
            fontFamily = poppinsSemiBold,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            SocialIcon(iconRes = R.drawable.ic_google)
            SocialIcon(iconRes = R.drawable.ic_facebook)
            SocialIcon(iconRes = R.drawable.ic_apple)
        }
    }
}