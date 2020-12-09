package eu.de.servicetestfragment.framework.db.note

import androidx.room.*
import eu.de.servicetestfragment.framework.db.BaseDao

@Dao
interface NoteDao:
    BaseDao<NoteEntity> {

    @Query("SELECT * FROM note")
    suspend fun getAllNoteEntities():List<NoteEntity>

    @Query("SELECT * FROM note WHERE noteId = :id")
    suspend fun getNoteEntity(id:Long): NoteEntity?


}