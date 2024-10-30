package com.example.mydailynote.auth.presentation

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mydailynote.R
import com.example.mydailynote.auth.presentation.util.TopCurve
import com.example.mydailynote.ui.theme.MyDailyNoteTheme
import com.example.mydailynote.widgets.button.CustomElevatedButton
import com.example.mydailynote.widgets.button.CustomTextButton
import com.example.mydailynote.widgets.textfiled.CustomOutlinedTextField

@Composable
fun LoginScreen() {
    val LocalGreeting = compositionLocalOf { "Default Greeting" }
    val context = LocalContext.current
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var usernameError by remember { mutableStateOf(false) }
    var passwordError by remember { mutableStateOf(false) }

//    // Gradient background
    val gradientBrush = Brush.verticalGradient(
        colors = listOf( Color.LightGray, Color.LightGray,Color.White, Color.White),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush)
            .padding(vertical = 50.dp),
    ) {
        // Left Image
        Image(
            painter = painterResource(id = R.drawable.splash_lg),
            contentDescription = "Left Logo",
            modifier = Modifier
                .size(195.dp) // Smaller size for illustration
                .align(Alignment.TopStart) // Aligns the image to the top-left
        )

        // Right Image
        Image(
            painter = painterResource(id = R.drawable.splash_lg),
            contentDescription = "Right Logo",
            modifier = Modifier
                .size(195.dp) // Smaller size for illustration
                .align(Alignment.TopEnd)
                .offset(x = (-20).dp, y = 80.dp) // Aligns the image to the top-right
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    vertical = 150.dp,
                    horizontal = 16.dp
                ),  // Add some padding to center between the images
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Image(
                painter = painterResource(id = R.drawable.splash_lg),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)          // Clip the image into a circular shape
                    .background(Color.Gray)
            )
            Text(

                modifier = Modifier.padding(top = 16.dp, start = 0.dp, bottom = 0.dp, end = 0.dp),
                text = "Wel Come Back",
                color = Color.Black,
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            // Username field
            CustomOutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = "Username",
                isError = usernameError,
                errorMessage = if (usernameError) "Username cannot be empty" else "",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Username Icon"
                    )
                }
            )

            // Password field with visibility toggle
            CustomOutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                isError = passwordError,
                errorMessage = if (passwordError) "Password cannot be empty" else "",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon"
                    )
                },
                //            trailingIcon = {
                //                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                //                    Icon(
                //                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                //                        contentDescription = "Toggle Password Visibility"
                //                    )
                //                }
                //            },
                keyboardType = if (passwordVisible) KeyboardType.Text else KeyboardType.Password
            )

            Spacer(modifier = Modifier.padding(10.dp))
            CustomElevatedButton(

                text = "Login",
                onClick = {

                    usernameError = username.isEmpty()
                    passwordError = password.isEmpty()

                    if (!usernameError && !passwordError) {
                        // Proceed with login logic here
                        Toast.makeText(
                            context,
                            "Logging in with Username: $username, Password: $password",
                            Toast.LENGTH_LONG
                        ).show()

                    }
                }
            )

            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "Don't Have Account?")
                CustomTextButton(
                    text = "Signup", onClick = { /*TODO*/ },
                    textColor = MaterialTheme.colorScheme.primary
                )
            }

            //        // testing
            //        CompositionLocalProvider(LocalGreeting provides "Welcome to India"   ) {
            //            Text(text = LocalGreeting.current)
            //        }
            //
            //        CompositionLocalProvider(LocalGreeting provides "Welcome to India ururuu"   ) {
            //            Text(text = LocalGreeting.current)
            //            Text(text = LocalGreeting.current)
            //        }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyDailyNoteTheme {
        LoginScreen()
    }
}