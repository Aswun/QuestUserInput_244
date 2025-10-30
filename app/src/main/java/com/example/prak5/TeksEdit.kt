import androidx.compose.runtime.Composable


@Composable
fun FormDataDiri(modifier: Modifier) {
    //variabel-variabel untuk mengingat nilai masukan dari keyboard
    var TextName by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textJK by remember { mutableStateOf("") }

    //variabel-variabel untuk menyimpan data yang diperoleh dari komponen
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender:List<String> = listOf("Laki-laki","Perempuan")

    Column(modifier = modifier.padding(top=50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = TextName,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = { TextName = it }
        )
    }
    Row {
        gender.forEach { item ->
            Row(modifier = Modifier.selectable(
                selected = textJK == item,
                onClick = { textJK = item }
            ), verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = textJK == item,
                    onClick = { textJK = item }
                )
                Text(text = item)
            }

        }
    }
})
