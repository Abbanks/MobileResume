package com.olubankeeboda.mobileresume.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olubankeeboda.mobileresume.data.OfflineFirstProfileDetailsRepository
import com.olubankeeboda.mobileresume.model.ProfileDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val profileDetailsRepository: OfflineFirstProfileDetailsRepository
) : ViewModel() {

    val uiState: StateFlow<EditScreenUiState> = profileDetailsRepository
        .profileDetails.map<ProfileDetails, EditScreenUiState> { EditScreenUiState.Success(data = it) }
        .catch { emit(EditScreenUiState.Error) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), EditScreenUiState.Loading)

    fun updateProfileDetails(details: ProfileDetails) {
        viewModelScope.launch {
            profileDetailsRepository.editProfileDetails(details)
        }
    }
}


sealed interface EditScreenUiState {
    object Loading : EditScreenUiState
    object Error : EditScreenUiState
    //data class Error(val throwable: Throwable) : MobileResumeUiState
    data class Success(val data: ProfileDetails) : EditScreenUiState
}

