package com.mifos.feature.groups.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mifos.feature.groups.sync_group_payloads.SyncGroupPayloadsScreenRoute

/**
 * Created by Pronay Sarker on 12/08/2024 (11:26 AM)
 */
const val SYNC_GROUP_PAYLOAD_ROUTE = "sync_group_payload_route"

fun NavController.navigateToSyncGroupPayloadScreen() {
    this.navigate(SYNC_GROUP_PAYLOAD_ROUTE)
}

fun NavGraphBuilder.syncGroupPayloadScreen(
    onBackPressed: () -> Unit
) {
    composable(SYNC_GROUP_PAYLOAD_ROUTE) {
        SyncGroupPayloadsScreenRoute(
            onBackPressed = onBackPressed
        )
    }
}