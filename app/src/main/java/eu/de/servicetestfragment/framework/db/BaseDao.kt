package eu.de.servicetestfragment.framework.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE


interface BaseDao <T>{

    @Insert(onConflict = REPLACE)
    suspend fun addNoteEntity(obj: T)

    @Delete
    suspend fun deleteNoteEntity(obj: T)
}