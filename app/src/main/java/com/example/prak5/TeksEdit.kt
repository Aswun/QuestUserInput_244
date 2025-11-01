package com.example.prak5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


@Composable
fun FormDataDiri(modifier: Modifier) {
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var namaInput by remember { mutableStateOf("") }
    var alamatInput by remember { mutableStateOf("") }
    var genderInput by remember { mutableStateOf("") }
    var statusInput by remember { mutableStateOf("") }

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen
    var namaHasil by remember { mutableStateOf("") }
    var alamatHasil by remember { mutableStateOf("") }
    var genderHasil by remember { mutableStateOf("") }
    var statusHasil by remember { mutableStateOf("") }


    val listGender = listOf("Laki-laki", "Perempuan")
    val listStatus = listOf("Janda", "Lajang", "Duda")

    Column (
        modifier = Modifier
        .fillMaxWidth()
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFF6A1B9A))
                .padding(start = 20.dp, bottom = 10.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(6.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                // Nama
                Text("Nama Lengkap", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = namaInput,
                    onValueChange = { namaInput = it },
                    label = { Text("Nama Lengkap") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.9f)
                )

                Text("Jenis Kelamin", fontWeight = FontWeight.SemiBold)
                listGender.forEach { opsi ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = genderInput == opsi,
                                onClick = { genderInput = opsi }
                            )
                            .padding(start = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = genderInput == opsi,
                            onClick = { genderInput = opsi }
                        )
                        Text(opsi)
                    }
                }

                Text("Status Perkawinan", fontWeight = FontWeight.SemiBold)
                listStatus.forEach { opsi ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = statusInput == opsi,
                                onClick = { statusInput = opsi }
                            )
                            .padding(start = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = statusInput == opsi,
                            onClick = { statusInput = opsi }
                        )
                        Text(opsi)
                    }
                }

                Text("Alamat", fontWeight = FontWeight.SemiBold)
                OutlinedTextField(
                    value = alamatInput,
                    onValueChange = { alamatInput = it },
                    label = { Text("Alamat Lengkap") },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.9f)
                )

                // Tombol Submit
                Button(
                    onClick = {
                        namaHasil = namaInput
                        genderHasil = genderInput
                        alamatHasil = alamatInput
                        statusHasil = statusInput
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
                    shape = RoundedCornerShape(30.dp),
                    enabled = alamatInput.isNotEmpty()
                ) {
                    Text("Submit", color = Color.White, fontSize = 16.sp)
                }

                ElevatedCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .height(120.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Black),
                    elevation = CardDefaults.cardElevation(10.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text("Nama   : $namaHasil", color = Color.White)
                        Text("Gender : $genderHasil", color = Color.White)
                        Text("Status : $statusHasil", color = Color.White)
                        Text("Alamat : $alamatHasil", color = Color.White)
                    }
                }
            }
        }
    }
}