package com.enriquediaz.appfitness

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enriquediaz.appfitness.ui.screen.EditProfileScreen
import com.enriquediaz.appfitness.ui.screen.ProfileScreen
import com.enriquediaz.appfitness.ui.theme.AppFitnessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppFitnessTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        FitnessApp()
                    }
                }
            }
        }
    }
}

@Composable
fun FitnessApp() {
    var nom by remember { mutableStateOf("Marc Torres") }
    var email by remember { mutableStateOf("marc.torres@fitness.com") }
    var dataNaixement by remember { mutableLongStateOf(940089600000L) }
    var genere by remember { mutableStateOf("Masculí") }
    var alcada by remember { mutableIntStateOf(180) }
    var pes by remember { mutableDoubleStateOf(82.5) }
    var pesObjectiu by remember { mutableDoubleStateOf(85.0) }
    var objectiu by remember { mutableStateOf("Guanyar massa muscular") }
    var nivellActivitat by remember { mutableStateOf("Intens") }
    var editant by remember { mutableStateOf(false) }

    if (editant) {
        EditProfileScreen(
            nom = nom,
            email = email,
            dataNaixement = dataNaixement,
            genere = genere,
            alcada = alcada,
            pes = pes,
            pesObjectiu = pesObjectiu,
            objectiu = objectiu,
            nivellActivitat = nivellActivitat,
            guardar = { nomN, emailN, dataNaixementN, genereN, alcadaN, pesN, pesObjectiuN, objectiuN, nivellActivitatN ->
                nom = nomN
                email = emailN
                dataNaixement = dataNaixementN
                genere = genereN
                alcada = alcadaN
                pes = pesN
                pesObjectiu = pesObjectiuN
                objectiu = objectiuN
                nivellActivitat = nivellActivitatN
                editant = false
            }
        )
    } else {
        ProfileScreen(
            nom = nom,
            email = email,
            dataNaixement = dataNaixement,
            genere = genere,
            alcada = alcada,
            pes = pes,
            objectiu = objectiu,
            nivellActivitat = nivellActivitat,
            editar = { editant = true }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppFitnessTheme {
        FitnessApp()
    }
}
