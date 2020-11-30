package eu.de.core.repository.note

import eu.de.core.data.note.Note

// durch private val  ist es verfügbar !!
class NoteRepository(private val dataSource2: NoteDataSource) {

    suspend fun addNote(note: Note)  = dataSource2.add(note)
    suspend fun getAllNote()  = dataSource2.getAll()
    suspend fun removeNote(note: Note)  = dataSource2.remove(note)
    suspend fun getNote(id: Long)  = dataSource2.get(id)

}