package ort.tp3.myapplication.ui.navigation

sealed class Routes(val route: String) {
   data object Welcome : Routes("welcome")
   data object Login : Routes("login")
   data object Register : Routes("register")
   data object Home : Routes("home")
   data object ProductDetail : Routes("product_detail")
   data object Favourites : Routes("favourites")
   data object Settings : Routes("settings")
   data object Profile : Routes("profile")

}
