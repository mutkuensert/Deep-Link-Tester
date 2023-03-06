package com.mutkuensert.deeplinktester.ui.home

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mutkuensert.deeplinktester.R

@Composable
fun Home() {
    val context = LocalContext.current

    val (link, onLinkChanged) = remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(150.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                value = link,
                onValueChange = onLinkChanged,
                singleLine = true,
                trailingIcon = {
                    IconButton(onClick = {
                        context.startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse(link)
                            ), null
                        )
                    }) {
                        Icon(
                            painter = painterResource(R.drawable.search),
                            contentDescription = "Search"
                        )
                    }
                })
        }
    }
}