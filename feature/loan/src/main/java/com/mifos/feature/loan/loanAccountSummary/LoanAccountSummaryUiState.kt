package com.mifos.feature.loan.loanAccountSummary

import com.mifos.core.objects.accounts.loan.LoanWithAssociations

/**
 * Created by Aditya Gupta on 08/08/23.
 */
sealed class LoanAccountSummaryUiState {

    data object ShowProgressbar : LoanAccountSummaryUiState()

    data class ShowFetchingError(val message: String) : LoanAccountSummaryUiState()

    data class ShowLoanById(val loanWithAssociations: LoanWithAssociations) : LoanAccountSummaryUiState()
}