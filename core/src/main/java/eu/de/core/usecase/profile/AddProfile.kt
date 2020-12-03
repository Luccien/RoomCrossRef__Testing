package eu.de.core.usecase.profile

import eu.de.core.data.profile.Profile
import eu.de.core.repository.profile.ProfileRepository

class AddProfile (private val profileRepository: ProfileRepository){

    suspend operator fun invoke(profile: Profile) = profileRepository.addProfile(profile)

}