package com.olubankeeboda.mobileresume.data

import com.olubankeeboda.mobileresume.database.ProfileDetailsEntity
import com.olubankeeboda.mobileresume.model.ProfileDetails
import kotlinx.coroutines.flow.Flow

interface ProfileDetailsRepository {
    val profileDetails: Flow<ProfileDetails>

    suspend fun editProfileDetails(details: ProfileDetails)
}