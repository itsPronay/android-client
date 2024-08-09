package com.mifos.mifosxdroid.components

import android.os.Bundle
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.fragment.findNavController
import com.mifos.core.common.utils.Constants
import com.mifos.core.objects.noncore.DataTable
import com.mifos.core.ui.components.FabType
import com.mifos.feature.about.AboutScreen
import com.mifos.feature.activate.ActivateScreen
import com.mifos.feature.center.center_details.CenterDetailsScreen
import com.mifos.feature.center.center_group_list.GroupListScreen
import com.mifos.feature.center.center_list.ui.CenterListScreen
import com.mifos.feature.center.create_center.CreateNewCenterScreen
import com.mifos.feature.checker_inbox_task.checker_inbox_tasks.ui.CheckerInboxTasksScreen
import com.mifos.feature.client.clientList.presentation.ClientListScreen
import com.mifos.feature.data_table.dataTableData.DataTableDataScreen
import com.mifos.feature.document.document_list.DocumentListScreen
import com.mifos.feature.groups.create_new_group.CreateNewGroupScreen
import com.mifos.feature.groups.group_details.GroupDetailsScreen
import com.mifos.feature.groups.group_list.GroupsListRoute
import com.mifos.feature.groups.sync_group_payloads.SyncGroupPayloadsScreenRoute
import com.mifos.feature.individual_collection_sheet.generate_collection_sheet.GenerateCollectionSheetScreen
import com.mifos.feature.individual_collection_sheet.individual_collection_sheet.ui.IndividualCollectionSheetScreen
import com.mifos.feature.loan.group_loan_account.GroupLoanAccountScreen
import com.mifos.feature.loan.loan_account.LoanAccountScreen
import com.mifos.feature.loan.loan_charge.LoanChargeScreen
import com.mifos.feature.loan.loan_transaction.LoanTransactionsScreen
import com.mifos.feature.note.NoteScreen
import com.mifos.feature.path_tracking.PathTrackingScreen
import com.mifos.feature.report.run_report.RunReportScreen
import com.mifos.feature.search.SearchScreenRoute
import com.mifos.feature.settings.settings.SettingsScreen
import com.mifos.mifosxdroid.Screens
import com.mifos.mifosxdroid.online.datatable.DataTableScreen
import com.mifos.mifosxdroid.online.savingsaccount.SavingsAccountScreen
import kotlin.test.todo

@Composable
fun Navigation(navController: NavHostController, padding: PaddingValues) {

    NavHost(navController = navController, startDestination = Screens.SearchScreen.route) {
        composable(Screens.SearchScreen.route) {
            SearchScreenRoute(
                modifier = Modifier.padding(padding),
                onFabClick = { fabType ->
                    when (fabType) {
                        FabType.CLIENT -> TODO()
                        FabType.CENTER -> navController.navigate(Screens.CreateNewCenterScreen.route)
                        FabType.GROUP -> navController.navigate(Screens.CreateNewGroupScreen.route)
                    }
                },
                onSearchOptionClick = { searchedEntity ->
                    when (searchedEntity.entityType) {
                        Constants.SEARCH_ENTITY_LOAN -> {
                            TODO()
                        }

                        Constants.SEARCH_ENTITY_CENTER -> {
                            TODO()
                        }

                        Constants.SEARCH_ENTITY_SAVING -> {
                            TODO()
                        }

                        Constants.SEARCH_ENTITY_GROUP -> {
                            TODO()
                        }

                        Constants.SEARCH_ENTITY_CLIENT -> {
                            TODO()
                        }
                    }
                }
            )
        }
        composable(Screens.ClientListScreen.route) {
            ClientListScreen(
                paddingValues = padding,
                createNewClient = {},
                syncClicked = {},
                onClientSelect = {}
            )
        }
        composable(Screens.CenterListScreen.route) {
            CenterListScreen(
                paddingValues = padding,
                createNewCenter = { navController.navigate(Screens.CreateNewCenterScreen.route) },
                syncClicked = { },
                onCenterSelect = { center ->
                    if (center.id != null) {
                        navController.navigate(Screens.CenterDetailsScreen.route + "/${center.id}")
                    }
                }
            )
        }
        composable(Screens.CenterDetailsScreen.route + "/{centerId}") {
            val centerId = it.arguments?.getInt("centerId") ?: 0
            CenterDetailsScreen(
                centerId = centerId,
                onBackPressed = { navController.navigateUp() },
                onActivateCenter = { navController.navigate(Screens.ActivateScreen.route + "/$centerId/${Constants.ACTIVATE_CENTER}") },
                addSavingsAccount = { TODO() },
                groupList = { navController.navigate(Screens.CenterGroupListScreen.route + "/$centerId") }
            )
        }

        composable(Screens.CenterGroupListScreen.route + "/{centerId}") {
            val centerId = it.arguments?.getInt("centerId") ?: 0
            GroupListScreen(
                centerId = centerId,
                onBackPressed = { navController.navigateUp() },
                loadClientsOfGroup = { TODO() }
            )
        }

        composable(Screens.GroupListScreen.route) {
            GroupsListRoute(
                paddingValues = padding,
                onAddGroupClick = { navController.navigate(Screens.CreateNewGroupScreen.route) },
                onGroupClick = { group ->
                    navController.navigate(Screens.GroupDetailsScreen.route + "/${group.id}/${group.name}")
                },
                onSyncClick = { TODO() }
            )
        }
        composable(Screens.GroupDetailsScreen.route + "/{groupId}/{groupName}") {
            val groupId = it.arguments?.getInt("groupId") ?: 0
            val groupName = it.arguments?.getString("groupName") ?: ""

            GroupDetailsScreen(
                groupId = groupId,
                groupName = groupName,
                onBackPressed = { navController.navigateUp() },
                addLoanAccount = { navController.navigate(Screens.GroupLoanAccountScreen.route + "/$groupId") },
                addSavingsAccount = { },
                documents = { navController.navigate(Screens.DocumentsScreen.route + "/$groupId/${Constants.ENTITY_TYPE_GROUPS}") },
                groupClients = { },
                moreGroupInfo = { navController.navigate(Screens.DataTableScreen.route + "/$groupId/${Constants.DATA_TABLE_NAME_GROUP}") },
                notes = { navController.navigate(Screens.NotesScreen.route + "/$groupId/${Constants.ENTITY_TYPE_GROUPS}") },
                loanAccountSelected = {},
                savingsAccountSelected = { _, _ -> },
                activateGroup = { navController.navigate(Screens.ActivateScreen.route + "/$groupId/${Constants.ACTIVATE_GROUP}") }
            )
        }

        composable(Screens.DataTableScreen.route + "/{entityId}/{dataTableName}" ){
            val entityId = (it.arguments?.getInt("entityId")) ?: 0
            val dataTableName = (it.arguments?.getString("dataTableName"))

            DataTableScreen(
                tableName = dataTableName,
                navigateBack = { navController.navigateUp() },
                onClick = { }
            )
        }

        composable(Screens.DataTableDataScreen.route + "/{dataTable}"){
//            val dataTable : DataTable = (it.arguments?.get ("dataTableName"))

        }
        composable(Screens.DocumentsScreen.route + "/{entityId}/{entityType}") {
            val entityId = it.arguments?.getInt("entityId") ?: 0
            val entityType = (it.arguments?.getString("entityType"))!!

            DocumentListScreen(
                entityType = entityType,
                entityId = entityId,
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(Screens.NotesScreen.route + "/{groupId}/{entityType}") {
            val groupId = it.arguments?.getInt("groupId") ?: 0
            val entityType = (it.arguments?.getString("entityType"))
            NoteScreen(
                entityId = groupId,
                entityType = entityType,
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(Screens.GroupLoanAccountScreen.route + "/groupId") {
            val groupId = it.arguments?.getInt("groupId") ?: 0
            GroupLoanAccountScreen(
                groupId = groupId,
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(Screens.ActivateScreen.route + "/{centerId}/{activateType}") {
            val centerId = (it.arguments?.getString("centerId"))!!.toInt()
            val activateType = (it.arguments?.getString("activateType"))!!
            ActivateScreen(
                id = centerId,
                activateType = activateType,
                onBackPressed = { navController.navigateUp() }
            )
        }
        composable(Screens.CheckerInboxAndTasksScreen.route) {
            CheckerInboxTasksScreen(
                onBackPressed = { navController.navigateUp() },
                checkerInbox = { }
            )
        }
        composable(Screens.IndividualCollectionSheetScreen.route) {
            IndividualCollectionSheetScreen(
                onBackPressed = { },
                onDetail = { String, IndividualCollectionSheet ->

                }
            )
        }
        composable(Screens.CollectionSheetScreen.route) {
            GenerateCollectionSheetScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }
        composable(Screens.RunReportsScreen.route) {
            RunReportScreen(
                onBackPressed = { navController.navigateUp() },
                onReportClick = {}
            )
        }
        composable(Screens.PathTrackerScreen.route) {
            PathTrackingScreen(
                onBackPressed = { navController.navigateUp() },
                onPathTrackingClick = { }
            )
        }
        composable(Screens.SettingsScreen.route) {
            SettingsScreen(
                onBackPressed = { navController.navigateUp() },
                navigateToLoginScreen = {

                },
                changePasscode = {},
                languageChanged = { },
                serverConfig = {}
            )
        }
        composable(Screens.AboutScreen.route) {
            AboutScreen(
                onBackPressed = { navController.navigateUp() }
            )
        }

        composable(Screens.OfflineSyncScreen.route) {

        }
        composable(Screens.CreateNewGroupScreen.route) {
            CreateNewGroupScreen(
                onGroupCreated = { }
            )
        }
        composable(Screens.CreateNewCenterScreen.route) {
            CreateNewCenterScreen(
                onCreateSuccess = {}
            )
        }
        composable(Screens.CreateNewClientScreen.route) {

        }


        composable(Screens.GroupDetailsScreen.route) {

        }

        composable(Screens.CreateNewGroupScreen.route) {
            CreateNewGroupScreen(
                onGroupCreated = { }
            )
        }
        composable(Screens.SyncGroupPayloadsScreen.route) {
            SyncGroupPayloadsScreenRoute(
                onBackPressed = {}
            )
        }
        composable(Screens.LoanAccountScreen.route) {
            LoanAccountScreen(
                clientId = 0, //TODO()
                onBackPressed = { /*TODO*/ },
                dataTable = { _, _ -> // TODO()

                }
            )
        }
        composable(Screens.LoanAccountSummaryScreen.route) {

        }
        composable(Screens.LoanApprovalScreen.route) {

        }
        composable(Screens.LoanChargeScreen.route) {
            LoanChargeScreen(
                loanAccountNumber = 0, // TODO()
                onBackPressed = { navController.navigateUp() }
            )
        }
        composable(Screens.LoanChargeDialogScreen.route) {

        }

        composable(Screens.LoanTransactionScreen.route + "/{loanId}") {
            val loanId = (it.arguments?.getString("loanId") ?: "0").toInt()
            LoanTransactionsScreen(
                loanId = loanId,
                navigateBack = { navController.navigateUp() }
            )
        }
        composable(Screens.LoanTransactionScreen.route) {

        }
        composable(Screens.LoanRepaymentScreen.route) {

        }

        composable(Screens.LoanDisbursementScreen.route) {

        }

        composable(Screens.LoanRepaymentScheduleScreen.route) {

        }


    }

}