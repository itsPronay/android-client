package com.mifos.feature.loan.loanAccount

import com.mifos.core.objects.organisation.LoanProducts

/**
 * Created by Aditya Gupta on 08/08/23.
 */
sealed class LoanAccountUiState {

    data object Loading : LoanAccountUiState()

    data class AllLoan(val productLoans: List<LoanProducts>) : LoanAccountUiState()

    data class Error(val message: Int) : LoanAccountUiState()

    data object LoanAccountCreatedSuccessfully : LoanAccountUiState()
}