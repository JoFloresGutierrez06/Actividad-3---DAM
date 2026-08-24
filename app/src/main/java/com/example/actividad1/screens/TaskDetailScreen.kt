package com.example.actividad1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.actividad1.Task

@Composable
fun TaskDetailScreen(
    task: Task,
    onBack: () -> Unit,
    onDelete: () -> Unit,
    onEdit: (String) -> Unit
) {
    var title by remember {
        mutableStateOf(task.title)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text("Detalle de la tarea")

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = {
                Text("Título")
            }
        )

        Text(
            text = if (task.completed) {
                "Completada"
            } else {
                "Pendiente"
            }
        )

        Button(
            onClick = {
                if (title.isNotBlank()) {
                    onEdit(title)
                }
            }
        ) {
            Text("Guardar cambios")
        }

        Button(
            onClick = onBack
        ) {
            Text("Regresar")
        }

        Button(
            onClick = onDelete
        ) {
            Text("Eliminar")
        }
    }
}