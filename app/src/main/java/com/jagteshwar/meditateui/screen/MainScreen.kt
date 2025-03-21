package com.jagteshwar.meditateui.screen

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jagteshwar.meditateui.ui.theme.MeditateUITheme

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(Color(0xFF040449))
        ) {
            Title()
            Spacer(modifier = Modifier.height(16.dp))
            MoodPanel()
        }
}

@Composable
fun Title() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween) {
Column {
    Text(text = "Good Morning, Jagteshwar",
        style = TextStyle(
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    )

    Spacer(modifier = Modifier.height(10.dp))

    Text(text = "We wish you have a good day!",
        style = TextStyle(
            color = Color.LightGray,
            fontWeight = FontWeight.Bold
        ),
        textAlign = TextAlign.End
    )
}

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                modifier = Modifier.size(50.dp),
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = Color.White
            )
        }
    }
}

@Composable
fun MoodPanel() {
    val mood = listOf("Sweet Sleep", "Insomnia", "Depression", "Happy", "Sad")
    var isSelected = false
    LazyRow(horizontalArrangement = Arrangement.spacedBy(15.dp)) {
            items(mood){
                Box(
                    modifier = Modifier
                        .height(35.dp)
                        .width(150.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .background(if(isSelected) Color(0xFF040449) else Color.Gray)
                        .padding(end = 5.dp)
                        .clickable {
                                   if(!isSelected){
                                       isSelected = true
                                   }else{
                                       isSelected = false
                                   }
                        },
                    contentAlignment = Alignment.Center
                ){
                Text(
                    text = it,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,

                    ),
                    textAlign = TextAlign.Center
                )
                }
            }
    }
}
@Preview
@Composable
fun PreviewMainScreen() {
    MeditateUITheme {
        MainScreen(modifier = Modifier)
    }
}