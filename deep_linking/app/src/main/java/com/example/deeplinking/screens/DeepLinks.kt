package com.example.deeplinking.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.deeplinking.ui.theme.greenColor

@Composable
fun DeepLinksUI(intent: Intent) {

    // on below line we are creating a variable for deep link
    val deepLinkMsg = remember {
        mutableStateOf("")
    }

    // getting the data from our
    // intent in our uri.
    val uri: Uri? = intent.data

    // checking if the uri is null or not.
    if (uri != null) {
        // if the uri is not null then we are getting the
        // path segments and storing it in list.
        val parameters: List<String> = uri.getPathSegments()

        // after that we are extracting string from that parameters.
        val param = parameters[parameters.size - 1]

        // on below line we are setting
        // that string to our text view
        // which we got as params.
        deepLinkMsg.value = param
    }

    // on below line we are creating a column for our ui.
    Column(
        // in this column we are adding a modifier for our column
        // and specifying max width, height and size.
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .fillMaxSize()

            // on below line we are adding padding
            // from all sides to our column.
            .padding(6.dp),

        // on below line we are adding vertical
        // arrangement for our column as bottom
        verticalArrangement = Arrangement.Center,

        // on below line we are adding
        // horizontal alignment for our column.
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // on below line we are displaying a simple text
        Text(

            // on below line we are specifying
            // modifier as padding for our text.
            modifier = Modifier.padding(6.dp),

            // on below line we are
            // specifying text as normal image.
            text = "Deep Links in Android",

            // on below line we are
            // specifying font weight as bold.
            fontWeight = FontWeight.Bold,

            // on below line we are setting
            // color for our text
            color = greenColor,

            // on below line we are
            // setting font size.
            fontSize = 20.sp
        )

        // on below line we are adding a spacer
        Spacer(modifier = Modifier.height(20.dp))


        // on below line we are displaying a simple text
        Text(

            // on below line we are specifying
            // modifier as padding for our text.
            modifier = Modifier.padding(6.dp),

            // on below line we are
            // specifying text as normal image.
            text = deepLinkMsg.value,

            // on below line we are specifying
            // font weight as bold.
            fontWeight = FontWeight.Bold,

            // on below line we are setting
            // color for our text
            color = greenColor,

            // on below line we are
            // setting font size.
            fontSize = 20.sp
        )

    }

}