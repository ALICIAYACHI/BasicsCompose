package com.basics.basicscompose.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.basics.basicscompose.R
import com.basics.basicscompose.ui.theme.BasicsComposeTheme

@Composable
fun BasicsScreen() {
    var name by remember { mutableStateOf("") }
    val topics = sampleItems() // datos que vienen de Datasource.kt

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo Compose
        Image(
            painter = painterResource(id = R.drawable.compose_logo),
            contentDescription = "Compose Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Conceptos básicos de Compose",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Campo de texto y botón
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Tu nombre") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { /* acción simulada */ }) {
                Text("Guardar")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista con LazyColumn
        Text(text = "Temas:", fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(topics) { topic ->
                TopicCard(topic.title, topic.description)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Logo Android extra
        Image(
            painter = painterResource(id = R.drawable.android_logo),
            contentDescription = "Android Logo",
            modifier = Modifier.size(80.dp)
        )
    }
}

@Composable
fun TopicCard(title: String, subtitle: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = title, fontWeight = FontWeight.Bold)
            Text(text = subtitle, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BasicsScreenPreview() {
    BasicsComposeTheme {
        BasicsScreen()
    }
}
