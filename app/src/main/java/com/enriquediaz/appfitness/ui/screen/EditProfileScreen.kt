package com.enriquediaz.appfitness.ui.screen

import android.R.attr.label
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.enriquediaz.appfitness.R
import com.enriquediaz.appfitness.ui.components.CalendariPicker
import com.enriquediaz.appfitness.ui.components.MenuDesplegable

@Composable
fun EditProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alcada: Int,
    pes: Double,
    pesObjectiu: Double,
    objectiu: String,
    nivellActivitat: String,
    guardar: (String, String, Long, String, Int, Double, Double, String, String) -> Unit
) {
    var nomNou: String by remember { mutableStateOf(nom) }
    var emailNou: String by remember { mutableStateOf(email) }
    var dataNaixementNou: Long by remember { mutableStateOf(dataNaixement) }
    var genereNou: String by remember { mutableStateOf(genere) }
    var alcadaNou: Int by remember { mutableStateOf(alcada) }
    var pesNou: Double by remember { mutableStateOf(pes) }
    var pesObjectiuNou: Double by remember { mutableStateOf(pes) }
    var objectiuNou: String by remember { mutableStateOf(objectiu) }
    var nivellActivitatNou: String by remember { mutableStateOf(nivellActivitat) }

    var opcionsGenere = listOf("Masculí", "Femení", "Prefereixo no dir-ho")
    var opcionsObjectius = listOf("Guanyar massa muscular", "Millorar la salut", "Mantenir el pes")
    var opcionsNivellActivitat = listOf("Relaxat", "Moderat", "Intens")

    Column(Modifier.padding(top = 24.dp)) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Black),
            )
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                horizontalAlignment = Alignment.End
            ) { // Alinea
                Button(onClick = {}) { Text(text = "Canviar foto") }
                Button(onClick = {}) { Text(text = "Eliminar foto") }
            }
        }
        Text(
            text = "Dades personals",
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            value = nomNou,
            onValueChange = { nomNou = it },
            label = { Text("Nom Complet") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = emailNou,
            onValueChange = { emailNou = it },
            label = { Text("Email") },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )


        // Data naixement
        CalendariPicker(
            label = "Data de naixement",
            selectedDateMillis = dataNaixementNou,
            onDateSelected = { dataNaixementNou = it},
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Genere
        MenuDesplegable(
            label = "Genere",
            opcions = opcionsGenere,
            valorSeleccionat = genereNou,
            onValorSeleccionat = { genereNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        Text(
            text = "Dades fisíques",
            fontWeight = FontWeight.Bold
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = alcadaNou.toString(),
                onValueChange = { alcadaNou = it.toIntOrNull() ?: alcadaNou },
                label = { Text("Alçada (cm)") },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )

            OutlinedTextField(
                value = pesNou.toString(),
                onValueChange = { pesObjectiuNou = it.toDoubleOrNull() ?: pesObjectiuNou },
                label = { Text("Pes (kg)") },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )

            OutlinedTextField(
                value = pesObjectiu.toString(),
                onValueChange = { pesObjectiuNou = it.toDoubleOrNull() ?: pesObjectiuNou },
                label = { Text("Alçada (cm)") },
                modifier = Modifier
                    .padding(8.dp)
                    .weight(1f)
            )
        }

        // Objectiu principal
        Text(
            text = "Objectiu principal",
            fontWeight = FontWeight.Bold
        )
        MenuDesplegable(
            label = "",
            opcions = opcionsObjectius,
            valorSeleccionat = objectiuNou,
            onValorSeleccionat = { objectiuNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Nível d'activitat
        Text(
            text = "Nível d'activitat",
            fontWeight = FontWeight.Bold
        )

        MenuDesplegable(
            label = "",
            opcions = opcionsNivellActivitat,
            valorSeleccionat = nivellActivitatNou,
            onValorSeleccionat = { nivellActivitatNou = it },
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        )

        // Boton guardar
        Button(onClick = { guardar(nomNou, emailNou, dataNaixementNou, genereNou, alcadaNou, pesNou, pesObjectiuNou, objectiuNou, nivellActivitatNou) }) {
            Text(text = "Guardar")
        }
    }
}
