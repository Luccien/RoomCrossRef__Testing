package eu.de.servicetestfragment.framework.db.profile

import android.content.Context
import eu.de.core.data.profile.Profile
import eu.de.core.repository.profile.ProfileDataSource
import eu.de.servicetestfragment.framework.db.DatabaseService
import eu.de.servicetestfragment.framework.db.noteWithProfiles.NoteWithProfiles
import eu.de.servicetestfragment.framework.db.profileWithNotes.ProfileWithNotes

class RoomProfileDataSource(context: Context):ProfileDataSource {

    val profileDao:ProfileDao = DatabaseService.getInstance(context).profileDao()

    //RoomProfileDataSource
    //override suspend fun add(profile: Profile) = profileDao.addEntity(ProfileEntity.fromProfile(profile))

    // todo add it to use cases -- does there need to be conversion?
    suspend fun getAllProfileWithNotes():List<ProfileWithNotes> = profileDao.getAllProfileWithNotes()

    suspend fun getAllNoteWithProfiles():List<NoteWithProfiles> = profileDao.getAllNoteWithProfiles()


    override suspend fun add(profile: Profile) = profileDao.addEntity(ProfileEntity.fromProfile(profile))

    override suspend fun get(id: Long): Profile? = profileDao.getProfile(id)?.toProfile()

    override suspend fun getAll(): List<Profile> = profileDao.getAllProfile().map{it.toProfile()}

    override suspend fun remove(profile: Profile) = profileDao.deleteEntity(ProfileEntity.fromProfile(profile))
}