package ort.tp3.myapplication.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ort.tp3.myapplication.ui.screens.*

@Composable
fun Scaffold() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    Scaffold(
        containerColor = Color(0xFFF5F0F0)
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.Welcome.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.Welcome.route) {
                WelcomeScreen(
                    onLoginClick = { navController.navigate(Routes.Login.route) },
                    onRegisterClick = { navController.navigate(Routes.Register.route) }
                )
            }

            composable(Routes.Login.route) {
                LoginScreen(
                    onNavigateToRegister = { navController.navigate(Routes.Register.route) },
                    onLoginSuccess = {
                        navController.navigate(Routes.Home.route) {
                            popUpTo(Routes.Welcome.route) { inclusive = true }
                        }
                    }
                )
            }

            composable(Routes.Register.route) {
                RegisterScreen(
                    onNavigateToLogin = { navController.navigate(Routes.Login.route) },
                    onRegisterSuccess = { navController.navigate(Routes.Home.route) }
                )
            }


            composable(Routes.Home.route) {
                MainLayoutScreen(navController = navController) { padding ->
                    HomeScreen(navController = navController, paddingValues = padding)
                }
            }

            composable(Routes.Favourites.route) {
                MainLayoutScreen(navController = navController) { innerPadding ->
                    FavouritesScreen(paddingValues = innerPadding)
                }
            }

            composable(Routes.Settings.route) {
                MainLayoutScreen(navController = navController) {
                    SettingsScreen(navController = navController)
                }
            }

            composable(Routes.Profile.route) {
                MainLayoutScreen(navController = navController) {
                    ProfileScreen()
                }
            }


            composable(Routes.ProductDetail.route) {
                MainLayoutScreen(navController = navController) { padding ->
                    ProductDetailScreen(
                        onBackClick = { navController.popBackStack() },
                        paddingValues = padding
                    )
                }
            }
        }
    }
}