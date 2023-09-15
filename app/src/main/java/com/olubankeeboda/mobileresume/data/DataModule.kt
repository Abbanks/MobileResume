package com.olubankeeboda.mobileresume.data

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindsProfileDetailsRepository(
        profileDetailsRepository: OfflineFirstProfileDetailsRepository
    ): ProfileDetailsRepository
}