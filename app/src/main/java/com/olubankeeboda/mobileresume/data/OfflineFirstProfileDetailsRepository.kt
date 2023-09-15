package com.olubankeeboda.mobileresume.data

import com.olubankeeboda.mobileresume.database.ProfileDetailsDao
import com.olubankeeboda.mobileresume.database.asExternalModel
import com.olubankeeboda.mobileresume.model.ProfileDetails
import com.olubankeeboda.mobileresume.model.asEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class OfflineFirstProfileDetailsRepository @Inject constructor(
    private val productDetailsDao: ProfileDetailsDao
) : ProfileDetailsRepository {

    override val profileDetails: Flow<ProfileDetails> =
        productDetailsDao.getProfileDetails().map { it.asExternalModel() }

    override suspend fun editProfileDetails(details: ProfileDetails) =
        productDetailsDao.insertProfileDetails(details.asEntity())
}