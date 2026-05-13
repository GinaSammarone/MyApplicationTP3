package ort.tp3.myapplication.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch
import ort.tp3.myapplication.ui.theme.poppinsFamily
import ort.tp3.myapplication.ui.components.CustomBottomAppBar
import ort.tp3.myapplication.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLayoutScreen(navController: NavController, content: @Composable (PaddingValues) -> Unit) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    val backgroundCanvas = Color(0xFFF5F1EF)
    val darkTextColor = Color(0xFF2C1911)

    val screenTitle = when (currentRoute) {
        Routes.Home.route -> "Shop list"
        Routes.Favourites.route -> "Favourites"
        Routes.Profile.route -> "Profile"
        Routes.Settings.route -> "Settings"
        Routes.ProductDetail.route -> "Leather boots"
        else -> "Shop list"
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerContainerColor = backgroundCanvas,
                drawerShape = RoundedCornerShape(topEnd = 24.dp, bottomEnd = 24.dp),
                modifier = Modifier.width(300.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Title",
                    modifier = Modifier.padding(horizontal = 28.dp, vertical = 8.dp),
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = poppinsFamily,
                    color = darkTextColor
                )
                Text(
                    text = "Section Header",
                    modifier = Modifier.padding(horizontal = 28.dp, vertical = 16.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = poppinsFamily,
                    color = darkTextColor.copy(alpha = 0.7f)
                )

                Spacer(modifier = Modifier.height(8.dp))


                DrawerItem(
                    label = "Shop list",
                    painter = rememberVectorPainter(Icons.Default.Circle),
                    selected = currentRoute == Routes.Home.route,
                    onClick = {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Routes.Home.route) navController.navigate(Routes.Home.route)
                    }
                )

                DrawerItem(
                    label = "Favourites",
                    painter = rememberVectorPainter(Icons.Filled.PlayArrow),
                    selected = currentRoute == Routes.Favourites.route,
                    badge = "3",
                    iconRotation = -90f,
                    iconSize = 24.dp,
                    onClick = {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Routes.Favourites.route) navController.navigate(Routes.Favourites.route)
                    }
                )

                DrawerItem(
                    label = "Profile",
                    painter = rememberVectorPainter(Icons.Default.Square),
                    selected = currentRoute == Routes.Profile.route,
                    onClick = {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Routes.Profile.route) navController.navigate(Routes.Profile.route)
                    }
                )

                DrawerItem(
                    label = "Settings",
                    painter = rememberVectorPainter(Icons.Default.Pentagon),
                    selected = currentRoute == Routes.Settings.route,
                    onClick = {
                        scope.launch { drawerState.close() }
                        if (currentRoute != Routes.Settings.route) navController.navigate(Routes.Settings.route)
                    }
                )
            }
        }
    ) {
        Scaffold(
            containerColor = backgroundCanvas,
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            text = screenTitle,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = poppinsFamily,
                            color = darkTextColor
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, null, tint = darkTextColor)
                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            if (currentRoute != Routes.Profile.route) {
                                navController.navigate(Routes.Profile.route)
                            }
                        }) {
                            Icon(
                                painterResource(id = R.drawable.ic_profile),
                                contentDescription = "Perfil",
                                tint = Color.Unspecified,
                                modifier = Modifier.size(32.dp)
                            )
                    }
                        },
                    colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.White)
                )
            },
            bottomBar = { CustomBottomAppBar(navController) }
        ) { innerPadding ->

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = innerPadding.calculateTopPadding())
            ) {

                content(innerPadding)
            }
        }
        }
    }


@Composable
fun CustomBottomAppBar(navController: NavController) {
    val terracotta = Color(0xFF9A4D28)
    val inactiveGray = Color(0xFFA6A6A6)

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    val barShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)

    Box(
        modifier = Modifier.fillMaxWidth().wrapContentHeight(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth().height(85.dp),
            color = Color.White,
            shape = barShape,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier.fillMaxSize().padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {

                BottomNavItem(
                    label = "Product",
                    painter = painterResource(id = R.drawable.ic_product),
                    selected = currentRoute == Routes.Home.route,
                    color = terracotta,
                    onClick = { if (currentRoute != Routes.Home.route) navController.navigate(Routes.Home.route) }
                )

                BottomNavItem("Search", painter = painterResource(id = R.drawable.ic_search), false, inactiveGray) {}

                Spacer(modifier = Modifier.width(60.dp))

                BottomNavItem("Cart", painter = painterResource(id = R.drawable.ic_cart), false, inactiveGray) {}


                BottomNavItem(

                    label = "Profile",
                    painter = painterResource(id = R.drawable.ic_user),
                    selected = currentRoute == Routes.Profile.route,
                    color = terracotta,
                    onClick = { if (currentRoute != Routes.Profile.route) navController.navigate(Routes.Profile.route) }
                )
            }
        }

        FloatingActionButton(
            onClick = { if (currentRoute != Routes.Home.route) navController.navigate(Routes.Home.route) },
            containerColor = terracotta,
            contentColor = Color.White,
            shape = CircleShape,
            modifier = Modifier.offset(y = (-30).dp).size(62.dp),
            elevation = FloatingActionButtonDefaults.elevation(6.dp)
        ) {
            Icon(Icons.Default.Storefront, null, modifier = Modifier.size(28.dp))
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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 8.dp)
            .width(60.dp)
            .height(60.dp)
            .offset(y = (-4).dp)
            .combinedClickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
    ) {
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
            color = if (selected) color else Color(0xFFA6A6A6),
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}
@Composable
fun DrawerItem(
    label: String,
    painter: Painter,
    selected: Boolean,
    badge: String? = null,
    iconRotation: Float = 0f,
    iconSize: Dp = 18.dp,
    onClick: () -> Unit
) {
    val darkTextColor = Color(0xFF2C1911)
    val selectedItemColor = Color(0xFFFFD8C4)

    NavigationDrawerItem(
        label = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = label,
                    fontFamily = poppinsFamily,
                    fontWeight = if (selected) FontWeight.Bold else FontWeight.SemiBold,
                    fontSize = 16.sp
                )
                if (badge != null) {
                    Text(
                        text = badge,
                        fontFamily = poppinsFamily,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
        },
        selected = selected,
        onClick = onClick,
        icon = {
            Icon(
                painter = painter,
                contentDescription = null,
                modifier = Modifier.size(iconSize)
                    .rotate(iconRotation),
                tint = if (label == "Favourites") Color.Black else darkTextColor            )
        },
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = selectedItemColor,
            unselectedContainerColor = Color.Transparent,
            selectedIconColor = darkTextColor,
            unselectedIconColor = darkTextColor,
            selectedTextColor = darkTextColor,
            unselectedTextColor = darkTextColor
        ),
        shape = RoundedCornerShape(30.dp),
        modifier = Modifier
            .padding(horizontal = 12.dp, vertical = 2.dp)
            .height(56.dp)
    )
}