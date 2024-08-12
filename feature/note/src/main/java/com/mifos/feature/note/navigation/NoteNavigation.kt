package com.mifos.feature.note.navigation

import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.note.NoteScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (12:01 PM)
 */
const val NOTE_SCREEN_ROUTE = "note_screen_route"

fun NavController.navigateToNoteScreen(entityId: Int, entityType: String) {
    this.navigate("$NOTE_SCREEN_ROUTE/$entityId/$entityType")
}

fun NavGraphBuilder.noteScreen(
    onBackPressed: () -> Unit,
) {
    composable(
        route = "$NOTE_SCREEN_ROUTE/{entityId}/{entityType}",
        arguments = listOf(
            navArgument(name = "entityId") { type = NavType.IntType },
            navArgument(name = "entityType") { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val entityId = backStackEntry.arguments?.getInt("entityId") ?: 0
        val entityType = backStackEntry.arguments?.getString("entityType") ?: ""

        NoteScreen(
            entityId = entityId,
            entityType = entityType,
            onBackPressed = onBackPressed
        )
    }
}