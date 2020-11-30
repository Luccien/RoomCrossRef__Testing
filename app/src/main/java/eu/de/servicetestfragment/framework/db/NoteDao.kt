package eu.de.servicetestfragment.framework.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface NoteDao: BaseDao<NoteEntity>{



    //@Insert(onConflict = REPLACE)
    //suspend fun addNoteEntity(noteEntity: NoteEntity)

    @Query("SELECT * FROM note")
    suspend fun getAllNoteEntities():List<NoteEntity>

    @Query("SELECT * FROM note WHERE id = :id")
    suspend fun getNoteEntity(id:Long): NoteEntity?


    @Delete
    suspend fun deleteNoteEntity(noteEntity: NoteEntity)

}