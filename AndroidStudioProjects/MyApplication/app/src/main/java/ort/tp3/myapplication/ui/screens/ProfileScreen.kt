package ort.tp3.myapplication.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ort.tp3.myapplication.R
import ort.tp3.myapplication.ui.theme.poppinsFamily

@Composable
fun ProfileScreen() {
    var email by remember { mutableStateOf("xxx@gmail.com") }
    var phone by remember { mutableStateOf("+5493123135") }
    var website by remember { mutableStateOf("www.google.com") }
    var password by remember { mutableStateOf("xxxxxxxxxxxxxxx") }

    val backgroundColor = Color(0xFFF8F4F1)
    val darkTextColor = Color(0xFF2C1911)
    val accentOrange = Color(0xFFE67E22)
    val fieldBorderColor = Color(0xFFBCAAA4)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(id = R.drawable.ic_picture),
                contentDescription = "Foto de perfil",
                modifier = Modifier
                    .size(160.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentScale = ContentScale.Crop
            )
            Surface(
                onClick = { },
                color = accentOrange,
                shape = CircleShape,
                modifier = Modifier
                    .size(42.dp)
                    .offset(x = (-8).dp, y = (-8).dp),
                shadowElevation = 4.dp
            ) {
                Icon(
                    Icons.Default.Edit,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.padding(10.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Martin",
            fontSize = 26.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            color = darkTextColor
        )
        Text(
            text = "UI UX DESIGN",
            fontSize = 15.sp,
            fontFamily = poppinsFamily,
            color = Color.Gray.copy(alpha = 0.8f),
            letterSpacing = 1.sp
        )

        Spacer(modifier = Modifier.height(40.dp))

        ProfileField(
            label = "E-Mail Address",
            value = email,
            onValueChange = { email = it },
            icon = Icons.Outlined.MailOutline

        )
        Spacer(modifier = Modifier.height(24.dp))

        ProfileField(
            label = "Phone Number",
            value = phone,
            onValueChange = { phone = it },
            icon = Icons.Outlined.Phone
        )
        Spacer(modifier = Modifier.height(24.dp))

        ProfileField(
            label = "Web Site",
            value = website,
            onValueChange = { website = it },
            icon = Icons.Outlined.Settings
        )
        Spacer(modifier = Modifier.height(24.dp))

        ProfileField(
            label = "Password",
            value = password,
            onValueChange = { password = it },
            icon = Icons.Outlined.Lock,
            isPassword = true
        )

        Spacer(modifier = Modifier.height(140.dp))
    }
}

@Composable
fun ProfileField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isPassword: Boolean = false
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, fontFamily = poppinsFamily, fontWeight = FontWeight.SemiBold) },
        modifier = Modifier.fillMaxWidth(),
        textStyle = LocalTextStyle.current.copy(fontFamily = poppinsFamily, fontWeight = FontWeight.Normal),
        trailingIcon = {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.Gray.copy(alpha = 0.6f),
                modifier = Modifier.size(28.dp)
            )
        },
        visualTransformation = if (isPassword)
            androidx.compose.ui.text.input.PasswordVisualTransformation()
        else androidx.compose.ui.text.input.VisualTransformation.None,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color(0xFF8D6E63),
            unfocusedBorderColor = Color.Gray.copy(alpha = 0.5f),
            focusedLabelColor = Color(0xFF8D6E63),
            unfocusedLabelColor = Color.Gray,
            focusedTextColor = Color(0xFF2C1911),
            unfocusedTextColor = Color.Gray
        ),
        singleLine = true
    )
}