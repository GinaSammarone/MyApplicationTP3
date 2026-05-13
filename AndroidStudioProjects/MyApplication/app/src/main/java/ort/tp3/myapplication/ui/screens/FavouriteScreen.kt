package ort.tp3.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ort.tp3.myapplication.R
import ort.tp3.myapplication.ui.components.FavouriteCard
import ort.tp3.myapplication.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavouritesScreen(paddingValues: PaddingValues) {
    val itemsFavoritos = listOf("Leather boots", "Leather boots", "Leather boots")
    val terracotta = Color(0xFF8D4B2D)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F0F0))
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = 16.dp,
                bottom = 100.dp
            ),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            itemsIndexed(itemsFavoritos) { index, item ->
                FavouriteCard(
                    number = (index + 1).toString(),
                    title = item,
                    price = "27,5",
                    imageRes = R.drawable.leather_boots
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Button(
                        onClick = { },
                        modifier = Modifier.height(40.dp).width(100.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = terracotta),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Add, null, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Buy", fontSize = 12.sp, fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold)
                        }
                    }
                }
            }
        }
    }
}