package ort.tp3.myapplication.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Storefront
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ort.tp3.myapplication.ui.navigation.Routes
import ort.tp3.myapplication.ui.theme.poppinsFamily
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import ort.tp3.myapplication.R


@Composable
fun CustomBottomAppBar(navController: NavController) {
    val terracotta = Color(0xFF9A4D28)
    val inactiveColor = Color(0xFF9EA3B0)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(130.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(95.dp),
            color = Color.White,
            shape = BottomBarShape(),
            shadowElevation = 12.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 35.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomNavItem(
                    label = "Product",
                    painter = painterResource(id = R.drawable.ic_product),
                    selected = currentRoute == Routes.Home.route,
                    color = terracotta,
                    onClick = {
                        if (currentRoute != Routes.Home.route) {
                            navController.navigate(Routes.Home.route) {
                                popUpTo(Routes.Home.route) { inclusive = true }
                            }
                        }
                    }
                )

                BottomNavItem("Search", painter = painterResource(id = R.drawable.ic_search), false, inactiveColor) {}

                Spacer(modifier = Modifier.width(100.dp))

                BottomNavItem("Cart", painter = painterResource(id = R.drawable.ic_cart), false, inactiveColor) {}

                BottomNavItem(
                    label = "Profile",
                    painter = painterResource(id = R.drawable.ic_user),
                    selected = currentRoute == Routes.Profile.route,
                    color = terracotta,
                    onClick = {
                        if (currentRoute != Routes.Profile.route) {
                            navController.navigate(Routes.Profile.route)
                        }
                    }
                )
            }
        }

        FloatingActionButton(
            onClick = {
                if (currentRoute != Routes.Home.route) navController.navigate(Routes.Home.route)
            },
            containerColor = terracotta,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .offset(y = 22.dp)
                .size(54.dp),
            elevation = FloatingActionButtonDefaults.elevation(10.dp)
        ) {
            Icon(painterResource(id = R.drawable.ic_central), null, modifier = Modifier.size(26.dp))
        }
    }
}
@Composable
fun BottomNavItem(
    label: String,
    painter: Painter,
    selected: Boolean,
    color: Color,
    onClick: () -> Unit
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier.size(60.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                painter = painter,
                contentDescription = label,
                tint = if (selected) color else Color(0xFFA6A6A6),
                modifier = Modifier.size(26.dp)
            )
            Text(
                text = label,
                fontSize = 11.sp,
                fontFamily = poppinsFamily,
                fontWeight = FontWeight.SemiBold,
                color = if (selected) color else Color(0xFF9EA3B0)
            )
        }
    }
}