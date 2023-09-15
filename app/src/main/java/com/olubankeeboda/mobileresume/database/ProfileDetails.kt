package com.olubankeeboda.mobileresume.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.olubankeeboda.mobileresume.model.ProfileDetails

@Entity(tableName = "profile_details")
data class ProfileDetailsEntity(
    @PrimaryKey
    val id: Int = 0,
    val fullName: String,
    val slackUsername: String,
    val gitHubHandle: String,
    val title: String,
    val bio: String,
    val education: String,
    val experience: String,
    val projects: String,
    val skills: String,
    val communities: String,
    val language: String
)

fun ProfileDetailsEntity.asExternalModel() = ProfileDetails(
    fullName = fullName,
    slackUsername = slackUsername,
    gitHubHandle = gitHubHandle,
    title = title,
    bio = bio,
    education = education,
    experience = experience,
    projects = projects,
    skills = skills,
    communities = communities,
    language = language
)

