package com.example.apitest

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.materialIcon
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.apitest.model.Mounts


@Composable
fun MountItem(mount: Mounts, onItemSelected: (String) -> Unit) { //(String) -> Unit quan no retorna res
    Card(
        border = BorderStroke(2.dp, Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemSelected(mount.name) }) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.a32), //imatge de placeholder fins q sapiguem fer servir la de l'api
                contentDescription = mount.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
            )
            Column {
                Text(
                    text = mount.name,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(text = mount.tooltip)

            }
        }
    }
}


@Composable
fun ListScreen() {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(getMountList()) { mount ->
            MountItem(mount = mount) {
                navController.navigate(Routes.DetailScreen.createRoute(mount.name)) //aixo no se com es posa be :')
            }
        }

    }
}