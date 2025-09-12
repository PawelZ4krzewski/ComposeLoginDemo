package pl.pawel.zakrzewski

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import composelogindemo.composeapp.generated.resources.Res
import composelogindemo.composeapp.generated.resources.pp
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier.size(80.dp),
                painter = painterResource(Res.drawable.pp),
                contentDescription = "Logo"
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Witamy ponownie!", style = MaterialTheme.typography.headlineSmall)

            Spacer(modifier = Modifier.height(16.dp))
            var email by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }
            var rememberMe by remember { mutableStateOf(false) }

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Hasło") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth()
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(checked = rememberMe, onCheckedChange = { rememberMe = it })
                    Text("Zapamiętaj mnie")
                }
                TextButton(onClick = { /* zapomniane hasło */ }) {
                    Text("Zapomniałeś hasła?")
                }
            }

            Button(onClick = { /* logowanie */ }, modifier = Modifier.fillMaxWidth()) {
                Text("Zaloguj się")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sekcja listy przewijalnej
        Text("Twoje powiadomienia", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))

        val notifications = remember {
            (1..50).map { index ->
                "Powiadomienie #$index" to "To jest opis powiadomienia numer $index."
            }
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(notifications) { notification ->
                NotificationItem(title = notification.first, description = notification.second)
            }
        }
    }
}

@Composable
fun NotificationItem(title: String, description: String) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
        ) {

            Icon(
                Icons.Default.Notifications,
                contentDescription = "Notification Icon",
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                Text(text = title, style = MaterialTheme.typography.bodyLarge)
                Text(text = description, style = MaterialTheme.typography.bodyMedium)
            }
        }
        HorizontalDivider(modifier = Modifier.padding(top = 16.dp))
    }
}
