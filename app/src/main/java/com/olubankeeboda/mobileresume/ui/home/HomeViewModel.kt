package com.olubankeeboda.mobileresume.ui.home

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
class HomeViewModel @Inject constructor(
    profileDetailsRepository: OfflineFirstProfileDetailsRepository
) : ViewModel() {

    val uiState: StateFlow<HomeScreenUiState> = profileDetailsRepository
        .profileDetails.map<ProfileDetails, HomeScreenUiState> { HomeScreenUiState.Success(data = it) }
        .catch { emit(HomeScreenUiState.Error) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), HomeScreenUiState.Loading)

    init {
        viewModelScope.launch {
            profileDetailsRepository.editProfileDetails(
                ProfileDetails(
                    fullName = "Abigail Oluwabanke Eboda",
                    slackUsername = "Olubanke",
                    title = "Android Kotlin Developer",
                    gitHubHandle = "Abbanks",
                    bio = "A native Android developer with less than 1 year of experience," + "\n" + "When I am not developing apps, I am watching movies or hang out with my friends.",
                    education = "University of Ilorin, Kwara, Nigeria—BSc Computer Science \n" + "October 2017 -  December 2022",
                    experience = "DevCareers—Android Developer(Intern)\n" + "August 2019 – November 2019\n" + "I was an intern in the program that supports beginner developers with resources to become professional developers. \n" + "\nNITDA - IT Intern\n" + "February 2020 - October 2020\n" + "I assisted in IT related tasks, learnt how to build a websites with Wordpress.\n" + "\n" + "NIGERIAN NAVY SHIP VICTORY - NYSC\n" + "February 2023 - In Progress\n" + "I perform administrative tasks for the project department such as applying for funds and compiling quotations for building maintenance and construction projects. I assist in making staff ID cards at the IT department.",
                    projects = "Track - Inventory App \n" + "The aim of this app was to keep track of its users’ products. \n" + "Utilized:  Kotlin, Room \n" + "\nSwift – Tracking App\n" + "The aim of this app was to build an app like Uber, the app finds the current location of a device on the Google Map, a login activity, etcetera.\n" + "Utilized: XML, Kotlin, Firebase\n" + "\nWeather Today  \n" + "This is a personal project I am currently working with  that notifies users on the current weather condition based on their preferences.  \n" + "Utilizing:  Kotlin, Retrofit, Room, Firebase, Jetpack Compose",
                    skills = "Beginner Skill:\n" + "- Java \n" + "Intermediate Skills:\n" + " Kotlin\n" + "Debugging and reading code written by others.\n" + "\n" + "Frontend Development: \n" + "XML\n" + "Jetpack Compose\n" + "\n" + "Backend Development\n" + "- Kotlin\n" + "\n" + "Databases:\n" + "- SQL\n" + "- Room\n" + "- Firebase\n" + " \n" + "Work Tools: \n" + "Android Studio\n" + "Slack\n" + "Git\n" + "Worklogs\n" + "Postman\n",
                    communities = "GDG/ DSC/ WOMEN TECHMAKERS, Kwara Chapter, Nigeria.\n" + "I joined and contributed to activities in the Google Developers Group, Developers Student Club, and Women Techmakers Club at my school.",
                    language = "English"
                )
            )
        }
    }

}


sealed interface HomeScreenUiState {
    object Loading : HomeScreenUiState
    object Error : HomeScreenUiState

    //data class Error(val throwable: Throwable) : HomeScreenUiState
    data class Success(val data: ProfileDetails) : HomeScreenUiState
}