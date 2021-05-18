package eu.de.core.repository.noteProfileCrossRef

import eu.de.core.data.noteProfileCrossRef.NoteProfileCrossRef

class NoteProfileCrossRefRepository(private val noteProfileCrossRefDataSource:NoteProfileCrossRefDataSource) {

  suspend fun addNoteProfileCrossRef(noteProfileCrossRef: NoteProfileCrossRef) = noteProfileCrossRefDataSource.add(noteProfileCrossRef)
    suspend fun getNoteProfileCrossRef(id: Long) = noteProfileCrossRefDataSource.get(id)
    suspend fun getAllNoteProfileCrossRef() = noteProfileCrossRefDataSource.getAll()
    suspend fun removeNoteProfileCrossRef(noteProfileCrossRef: NoteProfileCrossRef) = noteProfileCrossRefDataSource.remove(noteProfileCrossRef)



}