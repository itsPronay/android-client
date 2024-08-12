package com.mifos.feature.document.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.document.document_list.DocumentListScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (6:27 PM)
 */
const val DOCUMENT_LIST_SCREEN_ROUTE = "document_list_route"

fun NavController.navigateToDocumentListScreen(entityId: Int, entityType: String) {
    this.navigate("$DOCUMENT_LIST_SCREEN_ROUTE/$entityId/$entityType")
}

fun NavGraphBuilder.documentListScreen(
    onBackPressed: () -> Unit,
) {
    composable(
        route = "$DOCUMENT_LIST_SCREEN_ROUTE/{entityId}/{entityType}",
        arguments = listOf(
            navArgument(name = "entityId") { type = NavType.IntType },
            navArgument(name = "entityType") { type = NavType.StringType }
        )
    ) { navBackStackEntry ->
        val entityId = navBackStackEntry.arguments?.getInt("entityId") ?: 0
        val entityType = navBackStackEntry.arguments?.getString("entityType") ?: ""

        DocumentListScreen(
            entityId = entityId,
            entityType = entityType,
            onBackPressed = onBackPressed
        )
    }
}