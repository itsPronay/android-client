package com.mifos.feature.loan.group_loan_account.navigation

import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.loan.group_loan_account.GroupLoanAccountScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (3:19 PM)
 */
const val GROUP_LOAN_ACCOUNT_ROUTE = "group_loan_account_route"

fun NavController.navigateToGroupLoanAccountScreen(groupId: Int) {
    this.navigate("$GROUP_LOAN_ACCOUNT_ROUTE/$groupId")
}

fun NavGraphBuilder.groupLoanAccountScreen(
    onBackPressed: () -> Unit
) {
    composable(route = "$GROUP_LOAN_ACCOUNT_ROUTE/{groupId}",
        arguments = listOf(
            navArgument(name = "groupId") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val groupId = backStackEntry.arguments?.getInt("groupId") ?: 0

        GroupLoanAccountScreen(
            groupId = groupId,
            onBackPressed = onBackPressed
        )
    }
}