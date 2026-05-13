package ort.tp3.myapplication.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import ort.tp3.myapplication.R
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.ui.platform.LocalFocusManager

@Composable
fun AuthTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    isPassword: Boolean = false,
    isError: Boolean = false,
    imeAction: ImeAction = ImeAction.Next
) {
    val focusManager = LocalFocusManager.current
    val poppinsRegular = FontFamily(Font(R.font.poppins_regular))

    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it.replace("\n", "")) },
        placeholder = {
            Text(text = placeholder, fontFamily = poppinsRegular, color = Color.Gray)
        },
        modifier = Modifier.fillMaxWidth(),
        isError = isError,
        singleLine = true,

        keyboardOptions = KeyboardOptions(
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onNext = {
                focusManager.moveFocus(androidx.compose.ui.focus.FocusDirection.Down)
            },
            onDone = {
                focusManager.clearFocus()
            }
        ),

        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        shape = RoundedCornerShape(10.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF1F4FF),
            unfocusedContainerColor = Color(0xFFF1F4FF),
            errorContainerColor = Color(0xFFF1F4FF),
            focusedBorderColor = Color(0xFF1F41BB),
            unfocusedBorderColor = Color.Transparent,
            cursorColor = Color(0xFF1F41BB)
        )
    )
}