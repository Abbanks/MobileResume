package com.olubankeeboda.mobileresume.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [ProfileDetailsEntity::class], version = 1 , exportSchema = false)
abstract class ProfileDetailsDatabase : RoomDatabase() {
    abstract fun profileDetailsDao(): ProfileDetailsDao
}

