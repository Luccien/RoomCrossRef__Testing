package eu.de.servicetestfragment.framework.db.profile

import android.content.Context
import eu.de.core.data.profile.Profile
import eu.de.core.repository.profile.ProfileDataSource
import eu.de.servicetestfragment.framework.db.DatabaseService

class RoomProfileDataSource(context: Context):ProfileDataSource {

    val profileDao:ProfileDao = DatabaseService.getInstance(context).profileDao()

    override suspend fun add(profile: Profile) = profileDao.addEntity(ProfileEntity.fromProfile(profile))

    override suspend fun get(id: Long): Profile? = profileDao.getProfile(id)?.toProfile()

    override suspend fun getAll(): List<Profile> = profileDao.getAllProfile().map{it.toProfile()}

    override suspend fun remove(profile: Profile) = profileDao.deleteEntity(ProfileEntity.fromProfile(profile))
}