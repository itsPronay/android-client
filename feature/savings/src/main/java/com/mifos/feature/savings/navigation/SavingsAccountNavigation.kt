package com.mifos.feature.savings.navigation

import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.savings.account.SavingsAccountScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (3:35 PM)
 */
const val SAVINGS_ACCOUNT_SCREEN_ROUTE = "savings_account_navigation_route"

fun NavController.navigateToSavingsAccountScreen(
    groupId: Int,
    clientId: Int,
    isGroupAccount: Boolean
) {
    this.navigate("$SAVINGS_ACCOUNT_SCREEN_ROUTE/$groupId/$clientId/$isGroupAccount")
}

fun NavGraphBuilder.savingsAccountScreen(
    onBackPressed: () -> Unit
) {
    composable(route = "$SAVINGS_ACCOUNT_SCREEN_ROUTE/{groupId}/{clientId}/{isGroupAccount}",
        arguments = listOf(
            navArgument(name = "groupId") { type = NavType.IntType },
            navArgument(name = "clientId") { type = NavType.IntType },
            navArgument(name = "isGroupAccount") { type = NavType.BoolType }
        )
    ) { backStackEntry ->
        val groupId = backStackEntry.arguments?.getInt("groupId") ?: 0
        val clientId = backStackEntry.arguments?.getInt("clientId") ?: 0
        val isGroupAccount = backStackEntry.arguments?.getBoolean("isGroupAccount") ?: false

        SavingsAccountScreen(
            groupId = groupId,
            clientId = clientId,
            isGroupAccount = isGroupAccount,
            navigateBack = onBackPressed
        )
    }
}
