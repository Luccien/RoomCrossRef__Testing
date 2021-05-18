package eu.de.core.repository.profile

import eu.de.core.data.profile.Profile

interface ProfileDataSource {
    suspend fun add(profile: Profile)
    suspend fun get(id:Long):Profile?
    suspend fun getAll():List<Profile>
    suspend fun remove(profile: Profile)

}