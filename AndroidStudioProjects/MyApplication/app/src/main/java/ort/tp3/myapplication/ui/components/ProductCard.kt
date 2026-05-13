package ort.tp3.myapplication.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ort.tp3.myapplication.ui.theme.poppinsFamily

@Composable
fun ProductCard(
    title: String,
    price: String,
    description: String,
    imageRes: Int,
    onBuyClick: () -> Unit = {},
    onFavouriteClick: () -> Unit = {}
) {
    val terracotta = Color(0xFF9A4D28)
    val textDark = Color(0xFF2C1911)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 12.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 22.dp, vertical = 24.dp)
            ) {
                Text(
                    text = title,
                    fontSize = 14.sp,
                    fontFamily = poppinsFamily,
                    fontWeight = FontWeight.Bold,
                    color = textDark
                )

                Text(
                    text = "$price $",
                    fontSize = 12.sp,
                    fontFamily = poppinsFamily,
                    color = Color.Black,
                    modifier = Modifier.padding(top = 2.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                Text(
                    text = description,
                    fontSize = 10.5.sp,
                    fontFamily = poppinsFamily,
                    color = Color.Black,
                    lineHeight = 16.sp
                )

                Spacer(modifier = Modifier.height(32.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedButton(
                        onClick = onFavouriteClick,
                        modifier = Modifier
                            .height(40.dp)
                            .padding(end = 8.dp),
                        border = BorderStroke(1.2.dp, terracotta),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = terracotta)
                    ) {
                        Text(
                            text = "Add to favourite",
                            fontSize = 11.sp,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.SemiBold
                        )
                    }

                    Button(
                        onClick = onBuyClick,
                        modifier = Modifier
                            .height(40.dp)
                            .width(80.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = terracotta),
                        shape = RoundedCornerShape(20.dp)
                    ) {
                        Text(
                            text = "Buy",
                            fontSize = 12.sp,
                            color = Color.White,
                            fontFamily = poppinsFamily,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}