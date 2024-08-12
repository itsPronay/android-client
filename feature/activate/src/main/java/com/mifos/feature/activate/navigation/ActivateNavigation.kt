package com.mifos.feature.activate.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.activate.ActivateScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (5:16 PM)
 */
const val ACTIVATE_GROUP_ROUTE = "activate_group_route"

fun NavController.navigateToActivateScreen(id: Int, activateType: String) {
    this.navigate("$ACTIVATE_GROUP_ROUTE/$id/$activateType")
}

fun NavGraphBuilder.activateGroupScreen(
    onBackPressed: () -> Unit
) {
    composable(route = "$ACTIVATE_GROUP_ROUTE/{id}/{activateType}",
        arguments = listOf(
            navArgument("id") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val id = backStackEntry.arguments?.getInt("id") ?: 0
        val activateType = backStackEntry.arguments?.getString("activateType") ?: ""

        ActivateScreen(
            id = id,
            activateType = activateType,
            onBackPressed = onBackPressed
        )
    }
}
