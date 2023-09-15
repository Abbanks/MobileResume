package com.olubankeeboda.mobileresume.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.olubankeeboda.mobileresume.MobileResumeTopAppBar
import com.olubankeeboda.mobileresume.R
import com.olubankeeboda.mobileresume.model.ProfileDetails

object HomeDestination {
    const val route = "home"
    val titleRes = R.string.app_name
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navigateToEditScreen: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val homeScreenUiState: HomeScreenUiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MobileResumeTopAppBar(
                title = stringResource(HomeDestination.titleRes),
                canNavigateBack = false,
                scrollBehavior = scrollBehavior
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = navigateToEditScreen,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_large))
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = stringResource(R.string.edit_resume)
                )
            }
        },
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(16.dp),
            color = MaterialTheme.colorScheme.surface,
            tonalElevation = 16.dp,
            shape = ShapeDefaults.Large
        ) {
            if (homeScreenUiState is HomeScreenUiState.Success) {
                PersonalDetails(
                    items = (homeScreenUiState as HomeScreenUiState.Success).data,
                    modifier = modifier
                        .padding(innerPadding)
                )
            }
        }

    }
}

@Composable
fun PersonalDetails(
    modifier: Modifier = Modifier,
    items: ProfileDetails
) {

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(dimensionResource(id = R.dimen.padding_medium)),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = items.fullName,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = items.title,
                style = MaterialTheme.typography.bodyLarge
            )

        }

        Text(
            text = stringResource(id = R.string.slackUsername),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.slackUsername,
            style = MaterialTheme.typography.bodyLarge
        )



        Text(
            text = stringResource(id = R.string.gitHubHandle),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.gitHubHandle,
            style = MaterialTheme.typography.bodyLarge
        )


        Text(
            text = stringResource(id = R.string.bio),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.bio,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(id = R.string.education),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.education,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(id = R.string.experience),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.experience,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(id = R.string.skills),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.skills,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(id = R.string.projects),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.projects,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(id = R.string.communities),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.communities,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            text = stringResource(id = R.string.language),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = items.language,
            style = MaterialTheme.typography.bodyLarge
        )


    }


}