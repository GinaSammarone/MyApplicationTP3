package ort.tp3.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                // 1. Definimos el controlador de navegación
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    // 2. Configuramos las rutas
                    NavHost(navController = navController, startDestination = "welcome") {
                        composable("welcome") {
                            WelcomeScreen(
                                onNavigateToRegister = { navController.navigate("register") },
                                onNavigateToLogin = { navController.navigate("login") }
                            )
                        }
                        composable("register") {
                            Register(onNavigateToLogin = { navController.navigate("login") })
                        }
                        composable("login") {
                            Login(onNavigateToRegister = { navController.navigate("register") }) // Conectado a Register
                        }
                    }
                    }
                }
            }
        }
    }

    @Composable
    fun WelcomeScreen(
        onNavigateToRegister: () -> Unit,
        onNavigateToLogin: () -> Unit
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    color = Color(0xFFF1F4FF),
                    radius = 500f,
                    center = Offset(x = size.width * 0.1f, y = size.height * 0.02f)
                )
                drawCircle(
                    color = Color(0xFFF1F4FF),
                    radius = 400f,
                    center = Offset(x = size.width * 0.9f, y = size.height * 0.95f)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                Spacer(modifier = Modifier.height(60.dp))

                Image(
                    painter = painterResource(id = R.drawable.bienvenida_imagen),
                    contentDescription = "Welcome Illustration",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(350.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Discover Your\nDream Job here",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color(0xFF1F41BB),
                    textAlign = TextAlign.Center,
                    lineHeight = 45.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "Explore all the existing job roles based on your interest and study major",
                    fontSize = 14.sp,
                    color = Color.Black.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 20.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 60.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { onNavigateToLogin() }, // Llama a la navegación de Login
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                            .shadow(
                                12.dp,
                                shape = RoundedCornerShape(10.dp),
                                ambientColor = Color(0xFF1F41BB)
                            ),
                        shape = RoundedCornerShape(10.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1F41BB))
                    ) {
                        Text(text = "Login", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    }

                    TextButton(
                        onClick = { onNavigateToRegister() }, // Llama a la navegación de Register
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Register",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }
    }
