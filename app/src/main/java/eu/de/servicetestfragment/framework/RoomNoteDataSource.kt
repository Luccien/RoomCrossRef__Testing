package eu.de.servicetestfragment.framework

import android.content.Context
import eu.de.core.data.Note
import eu.de.core.repository.NoteDataSource
import eu.de.servicetestfragment.framework.db.DatabaseService
import eu.de.servicetestfragment.framework.db.NoteEntity

class RoomNoteDataSource(context:Context): NoteDataSource{
   val  noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) = noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Note? = noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll(): List<Note> = noteDao.getAllNoteEntities().map{it.toNote()}

    override suspend fun remove(note: Note) = noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}