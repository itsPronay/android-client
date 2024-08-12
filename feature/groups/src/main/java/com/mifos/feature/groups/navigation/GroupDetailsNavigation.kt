package com.mifos.feature.groups.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mifos.core.common.utils.Constants
import com.mifos.core.objects.accounts.savings.DepositType
import com.mifos.core.objects.client.Client
import com.mifos.feature.groups.group_details.GroupDetailsScreenRoute

/**
 * Created by Pronay Sarker on 12/08/2024 (4:40 AM)
 */
const val GROUP_DETAILS_SCREEN_ROUTE = "group_details_route"

fun NavController.navigateToGroupDetailsScreen(groupId : Int) {
    this.navigate("$GROUP_DETAILS_SCREEN_ROUTE/$groupId")
}

fun NavGraphBuilder.groupDetailsScreen(
    onBackPressed: () -> Unit,
    loadLoanAccountSummary: (Int) -> Unit,
    loadSavingsAccountSummary : (Int, DepositType) -> Unit,
    activateGroup: (Int) -> Unit,
    loadNotes: (Int) -> Unit,
    loadGroupDatatables : (Int , String) -> Unit,
    loadGroupClients: (List<Client>) -> Unit,
    loadDocuments : (Int) -> Unit,
    addGroupLoanAccount : (Int) -> Unit,
    addGroupSavingsAccount : (Int) -> Unit
) {
    composable(
        route = "$GROUP_DETAILS_SCREEN_ROUTE/{groupId}",
        arguments = listOf(
            navArgument(name = "groupId") { type = NavType.IntType },
        )
    ) { backStackEntry ->
        val groupID = backStackEntry.arguments?.getInt("groupId") ?: 0

        GroupDetailsScreenRoute(
            groupId = groupID,
            onBackPressed = onBackPressed,
            addLoanAccount = { addGroupLoanAccount(groupID) },
            addSavingsAccount = { addGroupSavingsAccount(groupID) },
            documents = { loadDocuments(groupID) },
            groupClients = loadGroupClients,
            moreGroupInfo = { loadGroupDatatables(groupID, Constants.DATA_TABLE_NAME_GROUP) },
            notes = { loadNotes(groupID) },
            loanAccountSelected = {  loadLoanAccountSummary(groupID) },
            savingsAccountSelected = { _, accountType -> loadSavingsAccountSummary(groupID, accountType) },
            activateGroup = { activateGroup(groupID) }
        )
    }
}