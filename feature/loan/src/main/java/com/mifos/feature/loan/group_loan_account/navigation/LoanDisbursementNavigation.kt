package com.mifos.feature.loan.group_loan_account.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.core.common.utils.Constants
import com.mifos.feature.loan.loan_disbursement.LoanAccountDisbursementScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (8:28 PM)
 */
const val LOAN_DISBURSEMENT_ROUTE = "loan_disbursement_route"

fun NavController.navigateToLoanDisbursementScreen(loanAccountNumber: Int) {
    this.navigate("$LOAN_DISBURSEMENT_ROUTE/$loanAccountNumber")
}

fun NavGraphBuilder.loanDisbursementScreen(
    onBackPressed: () -> Unit
) {
    composable(
        route = "$LOAN_DISBURSEMENT_ROUTE/{loanAccountNumber}",
        arguments = listOf(
            navArgument(name = "loanAccountNumber") { type = NavType.IntType }
        )
    ) { navBackStackEntry ->
        val loanAccountNumber = navBackStackEntry.arguments?.getInt("loanAccountNumber") ?: 0

        LoanAccountDisbursementScreen(
            loanId = loanAccountNumber,
            navigateBack = onBackPressed
        )
    }
}