package com.olubankeeboda.mobileresume.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.olubankeeboda.mobileresume.data.OfflineFirstProfileDetailsRepository
import com.olubankeeboda.mobileresume.model.ProfileDetails
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

//@Singleton
//class AppDatabaseCallback @Inject constructor(
//    private val profileDetailsRepository: OfflineFirstProfileDetailsRepository
//) : RoomDatabase.Callback() {
//
//
//    override fun onCreate(db: SupportSQLiteDatabase) {
//        super.onCreate(db)
//
//        // Use a CoroutineScope to insert initial data asynchronously
//        val ioScope = CoroutineScope(Dispatchers.IO)
//        ioScope.launch {
//            insertInitialData(profileDetailsRepository =profileDetailsRepository )
//        }
//    }
//
//    private suspend fun insertInitialData(profileDetailsRepository: OfflineFirstProfileDetailsRepository) {
//        // Prepopulate the database with initial data
//        profileDetailsRepository.editProfileDetails(
//            ProfileDetails(
//                fullName = "Abigail Oluwabanke Eboda",
//                slackUsername = "Olubanke",
//                title = "Android Kotlin Developer",
//                gitHubHandle = "Abbanks",
//                bio = "A native Android developer with less than 1 year of experience," + "\n" + "When I am not developing apps, I am watching movies or hang out with my friends.",
//                education = "University of Ilorin, Kwara, Nigeria—BSc Computer Science \n" + "October 2017 -  December 2022",
//                experience = "DevCareers—Android Developer(Intern)\n" + "August 2019 – November 2019\n" + "I was an intern in the program that supports beginner developers with resources to become professional developers. \n" + "\nNITDA - IT Intern\n" + "February 2020 - October 2020\n" + "I assisted in IT related tasks, learnt how to build a websites with Wordpress.\n" + "\n" + "NIGERIAN NAVY SHIP VICTORY - NYSC\n" + "February 2023 - In Progress\n" + "I perform administrative tasks for the project department such as applying for funds and compiling quotations for building maintenance and construction projects. I assist in making staff ID cards at the IT department.",
//                projects = "Track - Inventory App \n" + "The aim of this app was to keep track of its users’ products. \n" + "Utilized:  Kotlin, Room \n" + "\nSwift – Tracking App\n" + "The aim of this app was to build an app like Uber, the app finds the current location of a device on the Google Map, a login activity, etcetera.\n" + "Utilized: XML, Kotlin, Firebase\n" + "\nWeather Today  \n" + "This is a personal project I am currently working with  that notifies users on the current weather condition based on their preferences.  \n" + "Utilizing:  Kotlin, Retrofit, Room, Firebase, Jetpack Compose",
//                skills = "Beginner Skill:\n" + "- Java \n" + "Intermediate Skills:\n" + " Kotlin\n" + "Debugging and reading code written by others.\n" + "\n" + "Frontend Development: \n" + "XML\n" + "Jetpack Compose\n" + "\n" + "Backend Development\n" + "- Kotlin\n" + "\n" + "Databases:\n" + "- SQL\n" + "- Room\n" + "- Firebase\n" + " \n" + "Work Tools: \n" + "Android Studio\n" + "Slack\n" + "Git\n" + "Worklogs\n" + "Postman\n",
//                communities = "GDG/ DSC/ WOMEN TECHMAKERS, Kwara Chapter, Nigeria.\n" + "I joined and contributed to activities in the Google Developers Group, Developers Student Club, and Women Techmakers Club at my school.",
//                language = "English"
//            )
//        )
////            ProfileDetailsEntity(
////                fullName = "Abigail Oluwabanke Eboda",
////                slackUsername = "Olubanke",
////                title = "Android Kotlin Developer",
////                gitHubHandle = "Abbanks",
////                bio = "A native Android developer with less than 1 year of experience," + "\n" + "When I am not developing apps, I am watching movies or hang out with my friends.",
////                education = "University of Ilorin, Kwara, Nigeria—BSc Computer Science \n" + "October 2017 -  December 2022",
////                experience = "DevCareers—Android Developer(Intern)\n" + "August 2019 – November 2019\n" + "I was an intern in the program that supports beginner developers with resources to become professional developers. \n" + "\nNITDA - IT Intern\n" + "February 2020 - October 2020\n" + "I assisted in IT related tasks, learnt how to build a websites with Wordpress.\n" + "\n" + "NIGERIAN NAVY SHIP VICTORY - NYSC\n" + "February 2023 - In Progress\n" + "I perform administrative tasks for the project department such as applying for funds and compiling quotations for building maintenance and construction projects. I assist in making staff ID cards at the IT department.",
////                projects = "Track - Inventory App \n" + "The aim of this app was to keep track of its users’ products. \n" + "Utilized:  Kotlin, Room \n" + "\nSwift – Tracking App\n" + "The aim of this app was to build an app like Uber, the app finds the current location of a device on the Google Map, a login activity, etcetera.\n" + "Utilized: XML, Kotlin, Firebase\n" + "\nWeather Today  \n" + "This is a personal project I am currently working with  that notifies users on the current weather condition based on their preferences.  \n" + "Utilizing:  Kotlin, Retrofit, Room, Firebase, Jetpack Compose",
////                skills = "Beginner Skill:\n" + "- Java \n" + "Intermediate Skills:\n" + " Kotlin\n" + "Debugging and reading code written by others.\n" + "\n" + "Frontend Development: \n" + "XML\n" + "Jetpack Compose\n" + "\n" + "Backend Development\n" + "- Kotlin\n" + "\n" + "Databases:\n" + "- SQL\n" + "- Room\n" + "- Firebase\n" + " \n" + "Work Tools: \n" + "Android Studio\n" + "Slack\n" + "Git\n" + "Worklogs\n" + "Postman\n",
////                communities = "GDG/ DSC/ WOMEN TECHMAKERS, Kwara Chapter, Nigeria.\n" + "I joined and contributed to activities in the Google Developers Group, Developers Student Club, and Women Techmakers Club at my school.",
////                language = "English"
////            )
////        )
//
//    }
//}
