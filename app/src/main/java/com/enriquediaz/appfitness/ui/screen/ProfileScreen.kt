package com.enriquediaz.appfitness.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enriquediaz.appfitness.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun ProfileScreen(
    nom: String,
    email: String,
    dataNaixement: String,
    genere: String,
    alcada: Int,
    pes: Double,
    objectiu: String,
    nivellActivitat: String,
    editar: () -> Unit
) {

    Column() {
        // Caja de foto, nombre y email
        Column(
            Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null,
                Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )

            Text(
                text = nom, fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = email, fontSize = 16.sp,
                color = Color.Gray
            )
        }

        // Caja de información
        Card(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Column() {
                    Text(
                        "Edat",
                        color = Color.Gray
                    )
                    // Calcular edat
                    val edat = calcularEdad(dataNaixement)
                    Text(
                        edat.toString(),
                        fontWeight = FontWeight.Bold
                    )

                }
                Column() {
                    Text(
                        "Genere",
                        color = Color.Gray
                    )
                    Text(
                        genere,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column() {
                    Text(
                        "Alçcada",
                        color = Color.Gray
                    )
                    Text(
                        "$alcada cm",
                        fontWeight = FontWeight.Bold
                    )
                }
                Column() {
                    Text(
                        "pes",
                        color = Color.Gray
                    )
                    Text(
                        "$pes kg",
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }

        // Caja de objetivos
        Text(
            "Objectius", fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Column() {
            Card(
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(objectiu, Modifier.padding(8.dp))
            }
        }


        // Caja nivel de actividad
        Text(
            "Nivell d'actvitat", fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(nivellActivitat, Modifier.padding(8.dp))
        }
    }

    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_edit),
            contentDescription = "Edit",
            alignment = Alignment.TopEnd,
            modifier = Modifier
                .size(64.dp)
                .clickable { editar() }

        )
    }
}

fun calcularEdad(dataNaixement: String): Int {
    return try {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val fechaNac = sdf.parse(dataNaixement) ?: return 0

        val calNac = Calendar.getInstance().apply { time = fechaNac }
        val calHoy = Calendar.getInstance()

        var edat = calHoy.get(Calendar.YEAR) - calNac.get(Calendar.YEAR)

        // Si aún no ha cumplido años este año, restamos 1
        if (calHoy.get(Calendar.DAY_OF_YEAR) < calNac.get(Calendar.DAY_OF_YEAR)) {
            edat--
        }

        if (edat < 0) 0 else edat
    } catch (e: Exception) {
        0
    }
}