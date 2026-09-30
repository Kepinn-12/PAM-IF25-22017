package com.example.tugas3pam_124140073

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.DrawableResource


import tugas3pam_124140073.shared.generated.resources.Res
import tugas3pam_124140073.shared.generated.resources.foto_profil
import tugas3pam_124140073.shared.generated.resources.telephone
import tugas3pam_124140073.shared.generated.resources.email
import tugas3pam_124140073.shared.generated.resources.location
import tugas3pam_124140073.shared.generated.resources.ig


@Composable
@Preview
fun App() {
    val teksUtama = Color(0xFF222831)
    val aksenUtama = Color(0xFF77D26D)
    val bgTerang = Color(0xFFDDEED8)

    val customColors = lightColorScheme(
        primary = aksenUtama,
        onPrimary = Color.White,
        background = bgTerang,
        surface = Color.White,
        onSurface = teksUtama
    )

    MaterialTheme(colorScheme = customColors) {
        var isContactVisible by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .safeContentPadding(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            ProfileHeader(
                namaLengkap = "Jhon Kevin H. Tambun",
                deskripsi = "Informatika ITERA | ML Engineering"
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { isContactVisible = !isContactVisible },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.height(48.dp)
            ) {
                Text(
                    text = if (isContactVisible) "Tutup" else "Kontak",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            AnimatedVisibility(
                visible = isContactVisible,
                enter = fadeIn() + slideInVertically(initialOffsetY = { 50 })
            ) {
                ProfileContactCard(
                    email = "kev.124140073@student.itera.ac.id",
                    noTelp = "+62 812983262",
                    lokasi = "Empat Saudara Kost",
                    ig = "Kev.tbn10"
                )
            }
        }
    }
}

@Composable
fun ProfileHeader(namaLengkap: String, deskripsi: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth().padding(top = 40.dp, bottom = 16.dp)
    ) {
        Box(contentAlignment = Alignment.BottomEnd) {
            Image(
                painter = painterResource(Res.drawable.foto_profil),
                contentDescription = "Foto Profil",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(130.dp)
                    .clip(CircleShape)
                    .border(4.dp, Color.White, CircleShape)
            )
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF03BA47))
                    .border(2.dp, Color.Black, CircleShape)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = namaLengkap,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 22.sp,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = deskripsi,
            color = Color.Gray,
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.height(4.dp))
        
    }
}

@Composable
fun ProfileContactCard(email: String, noTelp: String, lokasi: String, ig: String) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 24.dp, vertical = 8.dp),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(24.dp)) {
            // Compose Item Info: Email
            ItemInfo(icon = Res.drawable.email, text = email)
            Spacer(modifier = Modifier.height(12.dp))
            // compose Item Info : Instagram
            ItemInfo(icon = Res.drawable.ig, text = ig)
            Spacer(modifier = Modifier.height(12.dp))
            // Compose Item Info: Phone
            ItemInfo(icon = Res.drawable.telephone, text = noTelp)
            Spacer(modifier = Modifier.height(12.dp))
            // Compose Item Info: Location
            ItemInfo(icon = Res.drawable.location, text = lokasi)
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { },
                modifier = Modifier.fillMaxWidth().height(40.dp),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Kirim Pesan", fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}

// Item Info (Reusable)
@Composable
fun ItemInfo(icon: DrawableResource, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 15.sp,
            color = MaterialTheme.colorScheme.onSurface,
            fontWeight = FontWeight.Medium
        )
    }
}