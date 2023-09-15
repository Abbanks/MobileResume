package com.olubankeeboda.mobileresume.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDetailsDao {
    @Query("SELECT * FROM profile_details")
    fun getProfileDetails(): Flow<ProfileDetailsEntity>

    @Upsert
    suspend fun insertProfileDetails(profileDetails: ProfileDetailsEntity)
}
