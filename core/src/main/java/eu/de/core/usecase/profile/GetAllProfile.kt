package eu.de.core.usecase.profile

import eu.de.core.data.profile.Profile
import eu.de.core.repository.profile.ProfileRepository

class GetAllProfile (private val profileRepository: ProfileRepository)
{
    suspend operator fun invoke():List<Profile> = profileRepository.getAllProfile()
    //fun getAllProfileWithNotes():List<ProfileWithNotes>
}