package com.example.actividad1.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.actividad1.Task
import androidx.compose.foundation.clickable
import androidx.compose.ui.Modifier

@Composable
fun TaskListScreen(
    tasks: List<Task>,
    onCompletedChange: (Task, Boolean) -> Unit, // "MainActivity, tú tienes los datos. Yo solamente te aviso cuando el usuario haga algo."
    onTaskClick: (Task) -> Unit
) {
    Column {
        Text("Mis tareas")

        LazyColumn {

            items(tasks) { task ->

                TaskItem(
                    task = task,
                    onCompletedChange = { completed ->
                        onCompletedChange(task, completed)
                    },
                    onTaskClick = {
                        onTaskClick(task)
                    }
                )
            }
        }
    }
}

@Composable
fun TaskItem(
    task: Task,
    onCompletedChange: (Boolean) -> Unit,
    onTaskClick: () -> Unit
) {

    Row(
        modifier = Modifier.clickable {
            onTaskClick()
        }
    ) {

        Checkbox(
            checked = task.completed,
            onCheckedChange = onCompletedChange
        )

        Text(task.title)
    }
}
