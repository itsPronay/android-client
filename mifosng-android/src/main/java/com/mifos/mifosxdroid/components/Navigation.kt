package com.mifos.mifosxdroid.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.mifos.core.common.utils.Constants
import com.mifos.core.datastore.PrefManager
import com.mifos.feature.about.navigation.aboutScreen
import com.mifos.feature.activate.navigation.activateGroupScreen
import com.mifos.feature.activate.navigation.navigateToActivateScreen
import com.mifos.feature.center.navigation.centerListScreen
import com.mifos.feature.center.navigation.navigateToCenterList
import com.mifos.feature.checker_inbox_task.navigation.checkerInboxTasksScreen
import com.mifos.feature.client.navigation.clientListScreen
import com.mifos.feature.client.navigation.navigateToClientListScreen
import com.mifos.feature.document.navigation.documentListScreen
import com.mifos.feature.document.navigation.navigateToDocumentListScreen
import com.mifos.feature.groups.navigation.createNewGroupScreen
import com.mifos.feature.groups.navigation.groupDetailsScreen
import com.mifos.feature.groups.navigation.groupListScreen
import com.mifos.feature.groups.navigation.navigateToGroupDetailsScreen
import com.mifos.feature.groups.navigation.navigateToGroupList
import com.mifos.feature.groups.navigation.syncGroupPayloadScreen
import com.mifos.feature.individual_collection_sheet.navigation.generateCollectionSheetScreen
import com.mifos.feature.individual_collection_sheet.navigation.individualCollectionSheetScreen
import com.mifos.feature.loan.group_loan_account.navigation.groupLoanAccountScreen
import com.mifos.feature.loan.group_loan_account.navigation.loanAccountSummaryScreen
import com.mifos.feature.loan.group_loan_account.navigation.loanDisbursementScreen
import com.mifos.feature.loan.group_loan_account.navigation.loanRepaymentScheduleScreen
import com.mifos.feature.loan.group_loan_account.navigation.loanTransactionScreen
import com.mifos.feature.loan.group_loan_account.navigation.navigateToGroupLoanAccountScreen
import com.mifos.feature.loan.group_loan_account.navigation.navigateToLoanAccountSummary
import com.mifos.feature.loan.group_loan_account.navigation.navigateToLoanDisbursementScreen
import com.mifos.feature.loan.group_loan_account.navigation.navigateToLoanRepaymentSchedule
import com.mifos.feature.loan.group_loan_account.navigation.navigateToLoanTransactionScreen
import com.mifos.feature.note.navigation.navigateToNoteScreen
import com.mifos.feature.note.navigation.noteScreen
import com.mifos.feature.path_tracking.navigation.pathTrackingScreen
import com.mifos.feature.report.navigation.runReportsScreen
import com.mifos.feature.savings.navigation.navigateToSavingsAccountScreen
import com.mifos.feature.savings.navigation.savingsAccountScreen
import com.mifos.feature.search.Navigation.SEARCH_SCREEN_ROUTE
import com.mifos.feature.search.Navigation.searchScreen
import com.mifos.feature.settings.navigation.settingsScreen

@Composable
fun Navigation(
    navController: NavHostController,
    padding: PaddingValues,
    modifier: Modifier = Modifier,
    startDestination: String = SEARCH_SCREEN_ROUTE
) {
    val context = LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        searchScreen(
            modifier = Modifier.padding(padding),
            centerListScreen = { navController.navigateToCenterList() },
            groupListScreen = { navController.navigateToGroupList() },
            clientListScreen = { navController.navigateToClientListScreen() }
        )

        clientListScreen(
            paddingValues = padding,
            createNewClient = {},
            syncClicked = {},
            onClientSelect = {}
        )

        centerListScreen(
            paddingValues = padding,
            createNewCenter = {},
            syncClicked = {},
            onCenterSelect = {}
        )

        groupListScreen(
            paddingValues = padding,
            onAddGroupClick = {},
            onGroupClick = { group ->
                if (group.id != null) {
                    navController.navigateToGroupDetailsScreen(group.id!!)
                }
            },
            onSyncClick = { groupLists ->

            }
        )

        groupDetailsScreen(
            onBackPressed = { navController.popBackStack() },
            loadLoanAccountSummary = { navController.navigateToLoanAccountSummary(loanAccountId = it) },
            loadSavingsAccountSummary = { _, _ -> },
            loadNotes = { navController.navigateToNoteScreen(it, Constants.ENTITY_TYPE_GROUPS) },
            loadDocuments = { navController.navigateToDocumentListScreen(it, Constants.ENTITY_TYPE_GROUPS) },
            loadGroupDatatables = { _, _ -> TODO() },
            loadGroupClients = {},
            addGroupLoanAccount = { navController.navigateToGroupLoanAccountScreen(groupId = it) },
            activateGroup = { navController.navigateToActivateScreen(id = it, Constants.ACTIVATE_GROUP) },
            addGroupSavingsAccount = { groupId ->
                navController.navigateToSavingsAccountScreen(groupId = groupId, clientId = 0, isGroupAccount = true)
            }
        )

        loanDisbursementScreen { navController.popBackStack() }

        loanAccountSummaryScreen(
            onBackPressed = { navController.popBackStack() },
            disburseLoan = { navController.navigateToLoanDisbursementScreen(loanAccountNumber = it) },
            transactionClicked = { navController.navigateToLoanTransactionScreen(loadId = it) },
            loadLoanDataTables = { TODO() },
            onRepaymentScheduleClicked = { navController.navigateToLoanRepaymentSchedule(loanId = it) },
            onDocumentsClicked = { navController.navigateToDocumentListScreen(entityId = it, entityType = Constants.ENTITY_TYPE_LOANS) },
        )

        documentListScreen { navController.popBackStack() }

        loanRepaymentScheduleScreen { navController.popBackStack() }

        loanTransactionScreen { navController.popBackStack() }

        documentListScreen { navController.popBackStack() }

        activateGroupScreen { navController.popBackStack() }

        savingsAccountScreen { navController.popBackStack() }

        noteScreen { navController.popBackStack() }

        checkerInboxTasksScreen(
            onBackPressed = { navController.popBackStack() },
        )

        individualCollectionSheetScreen(
            onBackClicked = { navController.popBackStack() },
            onDetail = { String, IndividualCollectionSheet ->

            }
        )

        generateCollectionSheetScreen(
            onBackPressed = { navController.popBackStack() }
        )

        runReportsScreen(
            onBackPressed = { navController.popBackStack() },
            onReportClick = { }
        )

        pathTrackingScreen(
            onBackPressed = { navController.popBackStack() }
        )

        settingsScreen(
            navigateBack = { navController.popBackStack() },
            navigateToLoginScreen = {},
            changePasscode = {},
            languageChanged = { },
            serverConfig = {}
        )

        aboutScreen(
            onBackPressed = { navController.popBackStack() }
        )

        createNewGroupScreen {
            navController.popBackStack()
            val prefManager = PrefManager(context)
            if (prefManager.userStatus == Constants.USER_ONLINE) {
                TODO()
            }
        }

        syncGroupPayloadScreen(
            onBackPressed = { navController.popBackStack() }
        )

        groupLoanAccountScreen(
            onBackPressed = { navController.popBackStack() }
        )
    }
}