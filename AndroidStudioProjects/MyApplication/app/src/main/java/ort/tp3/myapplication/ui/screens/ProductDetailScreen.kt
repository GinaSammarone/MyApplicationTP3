package ort.tp3.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ort.tp3.myapplication.ui.theme.poppinsFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailScreen(onBackClick: () -> Unit, paddingValues: PaddingValues) {
    var expanded by remember { mutableStateOf(false) }
    var selectedSize by remember { mutableStateOf("") }
    var count by remember { mutableStateOf("Input") }
    val sizes = listOf("38", "39", "40", "41", "42")

    val brownColor = Color(0xFF9A4D28)
    val backgroundColor = Color(0xFFF8F4F1)
    val textColor = Color(0xFF2C1911)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(bottom = paddingValues.calculateBottomPadding())
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Select size",
            fontSize = 22.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            color = textColor,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Box(contentAlignment = Alignment.TopStart) {
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded },
            ) {
                OutlinedTextField(
                    value = if (selectedSize.isEmpty()) "Input" else selectedSize,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier
                        .menuAnchor()
                        .width(280.dp),
                    shape = RoundedCornerShape(8.dp),
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                    textStyle = LocalTextStyle.current.copy(fontFamily = poppinsFamily),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Gray,
                        unfocusedBorderColor = Color.Gray,
                        focusedTextColor = Color.DarkGray,
                        unfocusedTextColor = Color.DarkGray
                    )
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    sizes.forEach { size ->
                        DropdownMenuItem(
                            text = { Text(size, fontFamily = poppinsFamily) },
                            onClick = {
                                selectedSize = size
                                expanded = false
                            }
                        )
                    }
                }
            }
            Text(
                text = "Label",
                color = Color.Gray,
                fontSize = 12.sp,
                fontFamily = poppinsFamily,
                modifier = Modifier
                    .offset(x = 12.dp, y = (-8).dp)
                    .background(backgroundColor)
                    .padding(horizontal = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Count of producy",
            fontSize = 22.sp,
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Medium,
            color = textColor,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        Box(contentAlignment = Alignment.TopStart) {
            OutlinedTextField(
                value = count,
                onValueChange = { count = it },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                textStyle = LocalTextStyle.current.copy(fontFamily = poppinsFamily),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedTextColor = Color.DarkGray,
                    unfocusedTextColor = Color.DarkGray
                )
            )
            Text(
                text = "Label",
                color = Color.Gray,
                fontSize = 12.sp,
                fontFamily = poppinsFamily,
                modifier = Modifier
                    .offset(x = 12.dp, y = (-8).dp)
                    .background(backgroundColor)
                    .padding(horizontal = 4.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedButton(
                onClick = onBackClick,
                modifier = Modifier.width(100.dp).height(40.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, brownColor),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Back", color = brownColor, fontFamily = poppinsFamily, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }

            Button(
                onClick = { },
                modifier = Modifier.width(100.dp).height(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = brownColor),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 2.dp)
            ) {
                Text("Buy", color = Color.White, fontFamily = poppinsFamily, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}