package com.example.sportsteam


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sportsteam.ui.theme.SportsTeamTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.media.MediaPlayer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import com.example.sportsteam.screens.AchievementsScreen
import com.example.sportsteam.screens.FavouritesScreen
import com.example.sportsteam.screens.HomeScreen
import com.example.sportsteam.screens.PlayerDetailScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SportsTeamTheme {
                MainFunction()
            }
        }
    }
}


data class Player(
    val imageUrl: String,
    val name: String,
    val position: String,
    val sandwich: String,
    val fact: String
)

// step 1 create route classes
sealed class Screen(val route: String) {
    object Home : Screen("Home")
    object Favorite : Screen("Favourites")
    object Achievements : Screen("Achievements")
    object PlayerDetail : Screen("PlayerDetail/{playerName}") {
        fun createRoute(playerName: String) = "PlayerDetail/$playerName"
    }

}

// step 2 create navigation items here
data class NavItem(
    var label: String,
    var icon: ImageVector,
    var screen: Screen,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainFunction() {
    var selectedPlayerImageUrl by remember { mutableStateOf("") }
    var selectedPlayerName by remember { mutableStateOf("") }
    var selectedPlayerPosition by remember { mutableStateOf("") }
    var selectedPlayerSandwich by remember { mutableStateOf("") }
    var selectedPlayerFact by remember { mutableStateOf("") }
    var mediaPlayer: MediaPlayer? = null

    // step 4 initialise the nav controller here
    val navController = rememberNavController()

    val context = LocalContext.current

    // step 5 create list of navigation items
    val navItemList = listOf(
        NavItem(label = "Home", icon = Icons.Default.Home, screen = Screen.Home),
        NavItem(label = "Favourites", icon = Icons.Default.Favorite, screen = Screen.Favorite),
        NavItem(label = "Achievements", icon = Icons.Default.Star, screen = Screen.Achievements)
    )

    // define a variable to store the value of selected navigation item
    var selectedIndex by remember { mutableStateOf(0) }
    var isMusicPlaying by remember { mutableStateOf(false) }

    // mutable state list to hold favorite players
    var favouritePlayers by remember { mutableStateOf(mutableListOf<String>()) }

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text("Charlie Brown's Baseball") }) },
        bottomBar = {
            // step 7
            // bottom bar navigation here
            NavigationBar {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                            if (navController.currentDestination?.route != navItem.screen.route) {
                                navController.navigate(navItem.screen.route) {
                                    launchSingleTop =
                                        true // prevent multiple copies of same destination
                                    restoreState = true // restore state to previously selected item
                                }
                            }
                        },
                        label = { Text(text = navItem.label) },
                        icon = { navItem.icon }
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = setOnClickListener@{
                if (mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(context, R.raw.soundtrack)
                }
                if (mediaPlayer?.isPlaying == true) {
                    mediaPlayer?.pause()
                    isMusicPlaying = false
                } else {
                    mediaPlayer?.start()
                    isMusicPlaying = true
                }
            }) {
                val volumeIcon = if (isMusicPlaying) R.drawable.unmute else R.drawable.mute
                // Image source: https://icons8.com/icon/56021/speaker
                Image(
                    painter = painterResource(id = volumeIcon),
                    contentDescription = if (isMusicPlaying) "Playing Music" else "Mute Music",
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
            }
        }
    ) { innerPadding ->
        // set the Nav Graph
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    favoritePlayers = favouritePlayers,
                    onAddToFavorites = { playerName ->
                        if (!favouritePlayers.contains(playerName)) {
                            favouritePlayers = favouritePlayers.toMutableList().apply { add(playerName) }
                        }
                    },
                    onPlayerClick = { player ->
                        selectedPlayerImageUrl = player.imageUrl
                        selectedPlayerName = player.name
                        selectedPlayerPosition = player.position
                        selectedPlayerSandwich = player.sandwich
                        selectedPlayerFact = player.fact
                        navController.navigate(Screen.PlayerDetail.route)
                    }
                )
            }
            composable(Screen.Favorite.route) {
                FavouritesScreen(
                    favoritePlayers = favouritePlayers,
                    onRemoveFromFavorites = { playerName ->
                        favouritePlayers =
                            favouritePlayers.toMutableList().apply { remove(playerName) }
                    }
                )
            }
            composable(Screen.Achievements.route) { AchievementsScreen() }
            composable("PlayerDetail/{playerName}") { backStackEntry ->
                 PlayerDetailScreen(
                    imageUrl = selectedPlayerImageUrl,
                    playerName = selectedPlayerName,
                    position = selectedPlayerPosition,
                    sandwich = selectedPlayerSandwich,
                    fact = selectedPlayerFact
                ) {
                    navController.popBackStack()
                }

            }


        }
    }
}
