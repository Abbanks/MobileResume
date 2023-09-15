package com.olubankeeboda.mobileresume.model

import com.olubankeeboda.mobileresume.database.ProfileDetailsEntity

data class ProfileDetails(
    var fullName: String,
    var slackUsername: String,
    var gitHubHandle: String,
    var title: String,
    var bio: String,
    var education: String,
    var experience: String,
    var projects: String,
    var skills: String,
    var communities: String,
    var language: String
)

fun ProfileDetails.asEntity() = ProfileDetailsEntity(
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
