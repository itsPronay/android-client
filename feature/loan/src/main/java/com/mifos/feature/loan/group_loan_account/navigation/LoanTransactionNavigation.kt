package com.mifos.feature.loan.group_loan_account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.loan.loan_transaction.LoanTransactionsScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (8:59 PM)
 */
const val LOAN_TRANSACTION_ROUTE = "loan_transaction_route"

fun NavController.navigateToLoanTransactionScreen(loadId: Int) {
    this.navigate("$LOAN_TRANSACTION_ROUTE/$loadId")
}

fun NavGraphBuilder.loanTransactionScreen(
    onBackPressed: () -> Unit
) {
    composable(
        route = "$LOAN_TRANSACTION_ROUTE/{loadId}",
        arguments = listOf(
            navArgument(name = "loanId") { type = NavType.IntType }
        )
    ) { backStackEntry ->
        val loadId = backStackEntry.arguments?.getInt("loadId") ?: 0

        LoanTransactionsScreen(
            loanId = loadId,
            navigateBack = onBackPressed
        )
    }
}