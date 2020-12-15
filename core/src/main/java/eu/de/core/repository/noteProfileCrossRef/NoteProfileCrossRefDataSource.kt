package eu.de.core.repository.noteProfileCrossRef

import eu.de.core.data.noteProfileCrossRef.NoteProfileCrossRef

interface NoteProfileCrossRefDataSource {
    suspend fun add(noteProfileCrossRef:NoteProfileCrossRef)
    suspend fun get(id:Long):NoteProfileCrossRef?
    suspend fun getAll():List<NoteProfileCrossRef>
    suspend fun remove(noteProfileCrossRef:NoteProfileCrossRef)

}
