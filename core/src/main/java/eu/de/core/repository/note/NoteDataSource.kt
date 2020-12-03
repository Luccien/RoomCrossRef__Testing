package eu.de.core.repository.note

import eu.de.core.data.note.Note

interface NoteDataSource {

    suspend fun add(note: Note)

    suspend fun get(id: Long): Note?

    suspend fun getAll():List<Note>

    suspend fun remove(note: Note)
}