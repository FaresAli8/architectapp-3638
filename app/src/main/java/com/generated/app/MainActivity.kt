package com.generated.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.generated.app.data.AppDatabase
import com.generated.app.ui.FitnessScreen
import com.generated.app.ui.theme.FitnessTrackerTheme
import com.generated.app.viewmodel.FitnessViewModel
import com.generated.app.viewmodel.FitnessViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Manual Dependency Injection
        val database = AppDatabase.getDatabase(applicationContext)
        val factory = FitnessViewModelFactory(database.workoutDao())
        val viewModel = ViewModelProvider(this, factory)[FitnessViewModel::class.java]

        setContent {
            FitnessTrackerTheme {
                FitnessScreen(viewModel = viewModel)
            }
        }
    }
}