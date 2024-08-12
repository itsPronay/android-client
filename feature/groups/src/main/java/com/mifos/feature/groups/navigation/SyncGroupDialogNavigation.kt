package com.mifos.feature.groups.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mifos.feature.groups.sync_group_dialog.SyncGroupDialogScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (7:55 AM)
 */
const val SYNC_GROUPS_DIALOG_ROUTE = "sync_groups_dialog_route"

fun NavController.navigateToSyncGroupsDialog() {
    this.navigate(SYNC_GROUPS_DIALOG_ROUTE)
}

fun NavGraphBuilder.syncGroupsDialog() {
    composable(SYNC_GROUPS_DIALOG_ROUTE) {
        var showDialog by rememberSaveable { mutableStateOf(true) }
        if(showDialog){
            SyncGroupDialogScreen(
                dismiss = { showDialog = false },
                hide = { showDialog = false }
            )
        }
    }
}