package com.example.project.UI_Layer.screen.EmployeeListViewScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.project.R
import com.example.project.data.remote.model.Data

@Composable
fun ProfileCard(data: Data) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 15.dp
        )
        // elevation = 4.dp,
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
        ) {
            AsyncImage(
                model = data.image,
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Text(
                    text = "${data.name}",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = if (data.technology.toInt() == 1) "Android Developer" else "Ios Developer",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row(
                    modifier = Modifier.padding(vertical = 4.dp) // Optional for spacing
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mail), // Replace with your desired icon
                        contentDescription = "Email Icon",
                        modifier = Modifier.size(16.dp), // Adjust the size of the icon
                        tint = MaterialTheme.colorScheme.primary // Icon color
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing between the icon and text

                    Text(
                        text = data.email,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }


                Row(
                    modifier = Modifier.padding(vertical = 4.dp) // Optional for spacing
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_mobilenumber), // Replace with your desired icon
                        contentDescription = "Icon",
                        modifier = Modifier.size(16.dp), // Adjust the size of the icon
                        tint = MaterialTheme.colorScheme.primary // Icon color
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing between the icon and text

                    Text(
                        text = data.mobile_no,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Row(
                    modifier = Modifier.padding(vertical = 4.dp) // Optional for spacing
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_address), // Replace with your desired icon
                        contentDescription = " Icon",
                        modifier = Modifier.size(16.dp), // Adjust the size of the icon
                        tint = MaterialTheme.colorScheme.primary // Icon color
                    )

                    Spacer(modifier = Modifier.width(8.dp)) // Add spacing between the icon and text

                    Text(
                        text = data.address,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }
            }
        }
    }
}
