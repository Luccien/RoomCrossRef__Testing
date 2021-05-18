package eu.de.core.repository.profile

import eu.de.core.data.profile.Profile

class ProfileRepository(private val profileDataSource:ProfileDataSource) {

    suspend fun addProfile(profile: Profile) = profileDataSource.add(profile)
    suspend fun getProfile(id: Long) = profileDataSource.get(id)
    suspend fun getAllProfile() = profileDataSource.getAll()
    suspend fun removeProfile(profile: Profile) = profileDataSource.remove(profile)

}
