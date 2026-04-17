package ort.tp3.myapplication

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// COLORES PÚBLICOS (Sin la palabra private para que Register los vea)
val AppBlue = Color(0xFF1F41BB)
val InputFieldBackground = Color(0xFFF1F4FF)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(onNavigateToRegister: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = Color(0xFFF1F4FF), radius = 500f, center = Offset(x = size.width * 0.1f, y = size.height * 0.02f))
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Text(text = "Login here", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = AppBlue)
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Welcome back you’ve\nbeen missed!", fontSize = 20.sp, color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, lineHeight = 28.sp)

            Spacer(modifier = Modifier.height(60.dp))

            CustomTextField(value = email, onValueChange = { email = it }, placeholder = "Email")
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(value = password, onValueChange = { password = it }, placeholder = "Password", isPassword = true)

            Text(text = "Forgot your password?", color = AppBlue, fontWeight = FontWeight.SemiBold, fontSize = 14.sp, modifier = Modifier.align(Alignment.End).padding(vertical = 15.dp))

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = { /* Sign In */ },
                modifier = Modifier.fillMaxWidth().height(60.dp).shadow(15.dp, shape = RoundedCornerShape(10.dp), ambientColor = AppBlue, spotColor = AppBlue),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AppBlue)
            ) {
                Text(text = "Sign in", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(30.dp))

            TextButton(onClick = { onNavigateToRegister() }) {
                Text(text = "Create new account", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(bottom = 40.dp)) {
                Text(text = "Or continue with", fontSize = 14.sp, color = AppBlue, fontWeight = FontWeight.SemiBold)
                Spacer(modifier = Modifier.height(20.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(20.dp)) {
                    SocialIconButton(iconRes = R.drawable.ic_google)
                    SocialIconButton(iconRes = R.drawable.ic_facebook)
                    SocialIconButton(iconRes = R.drawable.ic_apple)
                }
            }
        }
    }
}

// ESTAS FUNCIONES QUEDAN ACÁ Y REGISTER LAS VA A USAR DESDE ACÁ
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value: String, onValueChange: (String) -> Unit, placeholder: String, isPassword: Boolean = false) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, color = Color.Gray, fontSize = 16.sp) },
        modifier = Modifier.fillMaxWidth().height(62.dp),
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = InputFieldBackground,
            unfocusedContainerColor = InputFieldBackground,
            focusedBorderColor = AppBlue,
            unfocusedBorderColor = Color.Transparent,
            cursorColor = AppBlue
        ),
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

@Composable
fun SocialIconButton(iconRes: Int) {
    Surface(
        onClick = { /* Acción */ },
        modifier = Modifier.size(width = 60.dp, height = 45.dp),
        shape = RoundedCornerShape(10.dp),
        color = Color(0xFFF1F1F1)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = iconRes), contentDescription = null, modifier = Modifier.size(24.dp))
        }
    }
}
