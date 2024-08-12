package com.mifos.feature.groups.navigation

import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.mifos.core.datastore.PrefManager
import com.mifos.core.designsystem.icon.MifosIcons.group
import com.mifos.core.objects.response.SaveResponse
import com.mifos.feature.groups.create_new_group.CreateNewGroupScreen

/**
 * Created by Pronay Sarker on 12/08/2024 (6:05 AM)
 */
const val CREATE_NEW_GROUP_ROUTE = "create_new_group_route"

fun NavController.navigateToCreateNewGroupScreen() {
    this.navigate(CREATE_NEW_GROUP_ROUTE)
}

fun NavGraphBuilder.createNewGroupScreen(
    onGroupCreated: (group: SaveResponse?) -> Unit
) {
    composable(route = CREATE_NEW_GROUP_ROUTE) {
        CreateNewGroupScreen(
            onGroupCreated = onGroupCreated
        )
    }
}