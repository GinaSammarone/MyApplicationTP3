package ort.tp3.myapplication

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Register(onNavigateToLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize().background(Color.White)) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawCircle(color = Color(0xFFF1F4FF), radius = 500f, center = Offset(x = size.width * 0.1f, y = size.height * 0.02f))
            drawCircle(color = Color(0xFFF1F4FF), radius = 400f, center = Offset(x = size.width * 0.9f, y = size.height * 0.95f))
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(text = "Create Account", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold, color = AppBlue)
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = "Create an account so you can explore all the existing jobs", fontSize = 14.sp, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(50.dp))

            CustomTextField(value = email, onValueChange = { email = it }, placeholder = "Email")
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(value = password, onValueChange = { password = it }, placeholder = "Password", isPassword = true)
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(value = confirmPassword, onValueChange = { confirmPassword = it }, placeholder = "Confirm Password", isPassword = true)

            Spacer(modifier = Modifier.height(50.dp))

            Button(
                onClick = { /* Registro */ },
                modifier = Modifier.fillMaxWidth().height(60.dp).shadow(15.dp, shape = RoundedCornerShape(10.dp), ambientColor = AppBlue, spotColor = AppBlue),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = AppBlue)
            ) {
                Text(text = "Sign up", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }

            Spacer(modifier = Modifier.height(25.dp))

            TextButton(onClick = { onNavigateToLogin() }) {
                Text(text = "Already have an account", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)
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