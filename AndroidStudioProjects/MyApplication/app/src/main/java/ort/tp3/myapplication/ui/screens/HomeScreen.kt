package ort.tp3.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import ort.tp3.myapplication.R
import ort.tp3.myapplication.ui.components.ProductCard
import ort.tp3.myapplication.ui.navigation.Routes

@Composable
fun HomeScreen(navController: NavController, paddingValues: PaddingValues) {
    val backgroundCanvas = Color(0xFFF6F1F0)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundCanvas),

        contentPadding = PaddingValues(bottom = paddingValues.calculateBottomPadding() + 40.dp,
            top = 16.dp, ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(5) {
            ProductCard(
                title = "Leather boots",
                price = "27,5",
                description = "Great warm shoes from the artificial leather. You can buy this model only in our shop",
                imageRes = R.drawable.leather_boots,
                onBuyClick = {
                    navController.navigate(Routes.ProductDetail.route)
                },
                onFavouriteClick = {
                    navController.navigate(Routes.Favourites.route)
                }
            )
        }
    }
}