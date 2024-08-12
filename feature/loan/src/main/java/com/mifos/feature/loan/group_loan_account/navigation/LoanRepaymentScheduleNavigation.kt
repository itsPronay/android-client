package com.mifos.feature.loan.group_loan_account.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.feature.loan.loan_repayment_schedule.LoanRepaymentScheduleScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (9:20 PM)
 */

const val LOAN_REPAYMENT_SCHEDULE_ROUTE = "loan_repayment_schedule_route"

fun NavController.navigateToLoanRepaymentSchedule(loanId: Int) {
    this.navigate("$LOAN_REPAYMENT_SCHEDULE_ROUTE/$loanId")
}

fun NavGraphBuilder.loanRepaymentScheduleScreen(
    onBackPressed: () -> Unit
) {
    composable(
        route = "$LOAN_REPAYMENT_SCHEDULE_ROUTE/{loanId}",
        arguments = listOf(
            navArgument("loanId") { type = NavType.IntType }
        )
    ) { navBackStackEntry ->
        val loanId = navBackStackEntry.arguments?.getInt("loanId") ?: 0
        LoanRepaymentScheduleScreen(
            navigateBack = onBackPressed,
            loanId = loanId
        )
    }
}