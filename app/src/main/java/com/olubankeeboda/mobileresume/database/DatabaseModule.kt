package com.olubankeeboda.mobileresume.database

import android.content.Context
import androidx.room.Room
import com.olubankeeboda.mobileresume.data.OfflineFirstProfileDetailsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun provideProfileDetailsDao(profileDetailsDatabase: ProfileDetailsDatabase): ProfileDetailsDao {
        return profileDetailsDatabase.profileDetailsDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext appContext: Context
    ): ProfileDetailsDatabase {
        return Room.databaseBuilder(
            appContext, ProfileDetailsDatabase::class.java, "mobile_resume_database"
        ).fallbackToDestructiveMigration().build()
    }

//    @Provides
//    @Singleton
//    fun provideAppDatabaseCallback(
//        @ApplicationContext appContext: Context
//    ): AppDatabaseCallback {
//        return AppDatabaseCallback( )
//    }
}
