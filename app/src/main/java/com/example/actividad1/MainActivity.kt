package com.example.actividad1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.remember
import com.example.actividad1.ui.theme.Actividad1Theme
import com.example.actividad1.screens.TaskListScreen //Importar la otra pantalla
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad1.screens.TaskDetailScreen
import com.example.actividad1.screens.CreateTaskScreen

import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.actividad1.screens.TaskViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {

            Actividad1Theme {

                val navController = rememberNavController()
                val taskViewModel: TaskViewModel = viewModel()

                NavHost(
                    navController = navController,
                    startDestination = "lista"
                ) {

                    composable("lista") {

                        TaskListScreen(
                            tasks = taskViewModel.tasks,
                            onTaskClick = { task ->
                                navController.navigate("detalle/${task.id}")
                            },
                            onCreateTask = {
                                navController.navigate("crear")
                            },
                            onDeleteTask = { task ->
                                taskViewModel.deleteTask(task)
                            }
                        )
                    }

                    composable("crear") {

                        CreateTaskScreen(
                            onSave = { title, date, priority, description ->
                                taskViewModel.addTask(title, date, priority, description)
                                navController.popBackStack()
                            },

                            onBack = {
                                navController.popBackStack()
                            }
                        )
                    }

                    composable("detalle/{id}") {

                        val id = it.arguments?.getString("id")?.toIntOrNull()

                        val task = taskViewModel.tasks.find { task ->
                            task.id == id
                        }

                        if (task != null) {
                            TaskDetailScreen(
                                task = task,

                                onBack = {
                                    navController.popBackStack()
                                },

                                onDelete = {
                                    taskViewModel.deleteTask(task)
                                    navController.popBackStack()
                                },

                                onEdit = { newTitle, newDate, newPriority, newDescription ->
                                    taskViewModel.editTask(
                                        task.id,
                                        newTitle,
                                        newDate,
                                        newPriority,
                                        newDescription
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
