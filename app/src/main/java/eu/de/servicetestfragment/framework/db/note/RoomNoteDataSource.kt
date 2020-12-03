package eu.de.servicetestfragment.framework.db.note

import android.content.Context
import eu.de.core.data.note.Note
import eu.de.core.repository.note.NoteDataSource
import eu.de.servicetestfragment.framework.db.DatabaseService

class RoomNoteDataSource(context:Context):
    NoteDataSource {
   val  noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addEntity(
        NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Note? = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll(): List<Note> = noteDao.getAllNoteEntities().map{it.toNote()}

    override suspend fun remove(note: Note) = noteDao.deleteEntity(
        NoteEntity.fromNote(note))
}