package com.mifos.feature.loan.group_loan_account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.loan.loan_account_summary.LoanAccountSummaryScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (6:59 PM)
 */
const val LOAN_ACCOUNT_SUMMARY_ROUTE = "loan_account_summary_route"

fun NavController.navigateToLoanAccountSummary(loanAccountId: Int) {
    this.navigate("$LOAN_ACCOUNT_SUMMARY_ROUTE/$loanAccountId")
}

fun NavGraphBuilder.loanAccountSummaryScreen(
    onBackPressed: () -> Unit,
    disburseLoan: (Int) -> Unit,
    loadLoanDataTables: (Int) -> Unit,
    transactionClicked: (Int) -> Unit,
    onRepaymentScheduleClicked: (Int) -> Unit,
    onDocumentsClicked: (Int) -> Unit
) {
    composable(
        route = "$LOAN_ACCOUNT_SUMMARY_ROUTE/{loanAccountId}",
        arguments = listOf(navArgument(name = "loanAccountId") { type = NavType.IntType })
    )
    { backStackEntry ->
        val loadAccountId = backStackEntry.arguments?.getInt("loanAccountId") ?: 0

        LoanAccountSummaryScreen(
            loanAccountNumber = loadAccountId,
            navigateBack = onBackPressed,
            onMoreInfoClicked = { loadLoanDataTables(loadAccountId) },
            onTransactionsClicked = transactionClicked,
            onRepaymentScheduleClicked = onRepaymentScheduleClicked,
            onDocumentsClicked = { onDocumentsClicked(loadAccountId) },
            onChargesClicked = { /*TODO*/  }, //check logic with the old fragment
            approveLoan = { },
            disburseLoan = { disburseLoan(loadAccountId) },
            onRepaymentClick = {  }
        )
    }
}