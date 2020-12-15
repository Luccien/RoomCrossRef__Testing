package eu.de.servicetestfragment.framework.db.noteProfileCrossRef

import android.content.Context
import eu.de.core.data.noteProfileCrossRef.NoteProfileCrossRef
import eu.de.core.repository.noteProfileCrossRef.NoteProfileCrossRefDataSource
import eu.de.servicetestfragment.framework.db.DatabaseService

class RoomNoteProfileCrossRefDataSource(context: Context) :NoteProfileCrossRefDataSource{

    val noteProfileCrossRefDao:NoteProfileCrossRefDao = DatabaseService.getInstance(context).noteProfileCrossRefDao()

    //override suspend fun add(profile: Profile) = profileDao.addEntity(ProfileEntity.fromProfile(profile))

    override suspend fun add(noteProfileCrossRef: NoteProfileCrossRef) = noteProfileCrossRefDao.addEntity(NoteProfileCrossRefEntity.fromNoteProfileCrossRef(noteProfileCrossRef))

    override suspend fun getAll(): List<NoteProfileCrossRef> = noteProfileCrossRefDao.getAllNoteProfileCrossRef().map{it.toNoteProfileCrossRef()}

    override suspend fun remove(noteProfileCrossRef: NoteProfileCrossRef) = noteProfileCrossRefDao.deleteEntity(NoteProfileCrossRefEntity.fromNoteProfileCrossRef(noteProfileCrossRef))

    override suspend fun get(id: Long): NoteProfileCrossRef? { // NOT NEEDED???
        TODO("Not yet implemented")
    }
/*
    override suspend fun get(id: Long): NoteProfileCrossRef? {
        TODO("Not yet implemented")
    }



    override suspend fun remove(noteProfileCrossRef: NoteProfileCrossRef) {
        TODO("Not yet implemented")
    }

 */
}