package eu.de.core.repository.note

import eu.de.core.data.note.Note


class NoteRepository(private val dataSource: NoteDataSource) {

    suspend fun addNote(note: Note)  = dataSource.add(note)
    suspend fun getAllNote()  = dataSource.getAll()
    suspend fun removeNote(note: Note)  = dataSource.remove(note)
    suspend fun getNote(id: Long)  = dataSource.get(id)

}