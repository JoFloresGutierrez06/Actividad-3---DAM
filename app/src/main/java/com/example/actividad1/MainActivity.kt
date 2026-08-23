package com.example.actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.actividad1.ui.theme.Actividad1Theme

class MainActivity : ComponentActivity() { //Es una clase Kotlin que hereda de ComponentActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Metodo del ciclo de vida de android
        enableEdgeToEdge()


        setContent { // Aquí aparece compose. Significa "a interfaz de esta Activity será la interfaz Compose que voy a declarar aquí."

            /*Actividad1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        equipo = "Superbuenaonda",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }*/
            // Lista estática de elementos
            /*val tasks = listOf(
                Task(1, "Comprar comida", false),
                Task(2, "Estudiar Kotlin", false),
                Task(3, "Hacer ejercicio", true),
                Task(4, "Comer yogurth", false)
            ) */

            val tasks = remember { // Remember significa: Compose, conserva este objeto mientras esta composición siga existiendo
                mutableStateListOf( // Lista mutable
                    Task(1, "Comprar comida", false),
                    Task(2, "Estudiar Kotlin", false),
                    Task(3, "Hacer ejercicio", true),
                    Task(4, "Comer yogurth", false)
                )
            }

            Column {
                Text("Mis tareas")

                LazyColumn { //Poner Alt + enter para importar automaticamente
                    items(tasks) { task ->
                        //Text(task.title)
                        //TaskItem(task) //Jala el "componente" de checkbox + título

                        TaskItem(
                            task = task,
                            onCompletedChange = { completed ->

                                val index = tasks.indexOfFirst { it.id == task.id }

                                tasks[index] = task.copy(completed = completed)
                            }
                        )
                    }
                }
            }
        }
    }
}

// El State le avisa a Compose que el estado de una tarea cambió, que vuelva a dibujar la interfaz

@Composable
fun TaskItem(task: Task,
             onCompletedChange: (Boolean) -> Unit) { //Es una función como parámetro
    Row {
        Checkbox(
            checked = task.completed, // Pregunta ¿Debes aparecer marcado? y la columna completed es booleano
            onCheckedChange = onCompletedChange
        )
        Text(task.title)
    }
}