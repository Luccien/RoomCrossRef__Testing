package eu.de.servicetestfragment.framework.db.profileWithNotes

import android.content.Context
import eu.de.servicetestfragment.framework.db.DatabaseService

class RoomProfileWithNotesDataSource(context:Context) {
    val profileWithNotesDao: ProfileWithNotesDao = DatabaseService.getInstance(context).profileWithNotesDao()

    //suspend fun add(profile: Profile) = profileDao.addEntity(ProfileEntity.fromProfile(profile))

    //suspend fun get(id: Long): Profile? = profileDao.getProfile(id)?.toProfile()

    suspend fun getAll(): List<ProfileWithNotesEntity> = profileWithNotesDao.getAllProfileWithNotes()  //getAllProfile().map{it.toProfile()}

    //suspend fun remove(profile: Profile) = profileDao.deleteEntity(ProfileEntity.fromProfile(profile))
}