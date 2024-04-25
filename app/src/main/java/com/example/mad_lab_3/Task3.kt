package com.example.mad_lab_3

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mad_lab_3.ui.theme.MADlab3Theme

class Task3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADlab3Theme{
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "Task3Screen"){
                    composable("Task3Screen"){
                        Task3Screen()
                    }
                    composable(
                        "detailScreen/{name}/{image}/{intro}",
                        arguments = listOf(
                            navArgument("name") { type = NavType.StringType },
                            navArgument("image") { type = NavType.IntType },
                            navArgument("intro") { type = NavType.StringType }
                        )
                    ){backStackEntry ->
                        val name = backStackEntry.arguments?.getString("name") ?: ""
                        val imageResId = backStackEntry.arguments?.getInt("image") ?: 0
                        val intro = backStackEntry.arguments?.getString("intro") ?: ""
                        DetailScreen(name, imageResId, intro)

                    }
                }

            }
        }
    }
}

@Composable
fun Task3Screen(){
   Box(
       modifier = Modifier.fillMaxSize(),
       contentAlignment = Alignment.Center
   ){
       Column(
           Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       ) {
            Text(
                text = "Friendsr",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
           Text(
               text = "Click on an eligible single user to learn more and see if you are compatible for date!",
               fontSize = 19.sp
           )
           LazyVerticalGrid(
               columns = GridCells.Fixed(2), // Number of columns
               contentPadding = PaddingValues(8.dp) // Padding around the grid
           ){
               val images = listOf(R.drawable.fawad, R.drawable.murphy, R.drawable.ana, R.drawable.pique)
               val names = listOf("Fawad", "Murphy", "Ana", "Pique")
               itemsIndexed(images) { index, image ->
                   Column (modifier = Modifier.padding(4.dp)){
                       Image(
                           painter = painterResource(id = image),
                           contentDescription = "Grid Image",
                           modifier = Modifier.clickable { Log.d("Hello Word", "Task3Screen: Clicked") } // Handle the click here
                       )
                       Text(
                           text = names[index],
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(4.dp),
                           textAlign = TextAlign.Center
                       )
                   }
               }
           }
       }
   }
}

@Composable
fun DetailScreen(name: String, imageResId: Int, intro: String){
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageResId),
            contentDescription = name,
            modifier = Modifier.size(200.dp) // Set your desired size
        )
        Text(text = name, style = MaterialTheme.typography.bodyLarge)
        Text(text = intro, style = MaterialTheme.typography.bodyMedium)
    }
}