package com.olubankeeboda.mobileresume.ui.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.olubankeeboda.mobileresume.MobileResumeTopAppBar
import com.olubankeeboda.mobileresume.R
import com.olubankeeboda.mobileresume.model.ProfileDetails
import kotlinx.coroutines.launch


object EditDestination {
    const val route = "edit"
    val titleRes = R.string.edit_resume
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun EditRoute(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    canNavigateBack: Boolean = true,
    viewModel: EditViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            MobileResumeTopAppBar(
                title = stringResource(EditDestination.titleRes),
                canNavigateBack = canNavigateBack,
                navigateUp = onNavigateUp
            )
        }
    ) { innerPadding ->

        val editScreenUiState: EditScreenUiState by viewModel.uiState.collectAsStateWithLifecycle()

        EditScreen(
            editScreenUiState = editScreenUiState,
            viewModel = viewModel,
            navigateBack = navigateBack,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        )
    }
}

@Composable
fun EditScreen(
    viewModel: EditViewModel,
    editScreenUiState: EditScreenUiState,
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.padding_large)),
        modifier = modifier
            .padding(dimensionResource(id = R.dimen.padding_medium))
            .verticalScroll(
                rememberScrollState()
            )
    ) {

        if (editScreenUiState is EditScreenUiState.Success) {
            EditDetails(
                items = editScreenUiState.data,
                modifier = Modifier.fillMaxWidth(),
                viewModel = viewModel,
                navigateBack = navigateBack
            )
        }

    }
}

@Composable
internal fun EditDetails(
    modifier: Modifier = Modifier,
    items: ProfileDetails,
    viewModel: EditViewModel,
    navigateBack: () -> Unit,
    enabled: Boolean = true
) {

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        var fullName by remember { mutableStateOf(items.fullName) }
        var slackUsername by remember { mutableStateOf(items.slackUsername) }
        var title by remember { mutableStateOf(items.title) }
        var gitHubHandle by remember { mutableStateOf(items.gitHubHandle) }
        var bio by remember { mutableStateOf(items.bio) }
        var education by remember { mutableStateOf(items.education) }
        var experience by remember { mutableStateOf(items.experience) }
        var projects by remember { mutableStateOf(items.projects) }
        var skills by remember { mutableStateOf(items.skills) }
        var communities by remember { mutableStateOf(items.communities) }
        var language by remember { mutableStateOf(items.language) }

        OutlinedTextField(
            value = fullName,
            onValueChange = { fullName = it },
            label = { Text(stringResource(R.string.fullName)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text(stringResource(R.string.title)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = gitHubHandle,
            onValueChange = { gitHubHandle = it },
            label = { Text(stringResource(R.string.gitHubHandle)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = slackUsername,
            onValueChange = { slackUsername = it },
            label = { Text(stringResource(R.string.slackUsername)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = true
        )

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text(stringResource(R.string.bio)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = false
        )

        OutlinedTextField(
            value = education,
            onValueChange = { education = it },
            label = { Text(stringResource(R.string.education)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = false
        )

        OutlinedTextField(
            value = experience,
            onValueChange = { experience = it },
            label = { Text(stringResource(R.string.experience)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = false
        )

        OutlinedTextField(
            value = projects,
            onValueChange = { projects = it },
            label = { Text(stringResource(R.string.projects)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = false
        )

        OutlinedTextField(
            value = skills,
            onValueChange = { skills = it },
            label = { Text(stringResource(R.string.skills)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = false
        )

        OutlinedTextField(
            value = communities,
            onValueChange = { communities = it },
            label = { Text(stringResource(R.string.communities)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = false
        )

        OutlinedTextField(
            value = language,
            onValueChange = { language = it },
            label = { Text(stringResource(R.string.language)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            singleLine = false
        )

        val coroutineScope = rememberCoroutineScope()

        Button(
            onClick = {
                coroutineScope.launch {
                    viewModel.updateProfileDetails(
                        ProfileDetails(
                            fullName,
                            slackUsername,
                            gitHubHandle,
                            title,
                            bio,
                            education,
                            experience,
                            projects,
                            skills,
                            communities,
                            language
                        )
                    )
                    navigateBack()
                }
            },
            enabled = true,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.save_action))
        }

    }
}


