package eu.de.servicetestfragment.framework.db

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE


interface BaseDao <T>{

    @Insert(onConflict = REPLACE)
    suspend fun addEntity(obj: T)

    @Delete
    suspend fun deleteEntity(obj: T)
}