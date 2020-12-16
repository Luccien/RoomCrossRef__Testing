package eu.de.servicetestfragment.framework.db.profileWithNotes

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import eu.de.servicetestfragment.framework.db.BaseDao

@Dao
interface ProfileWithNotesDao : BaseDao<ProfileWithNotesEntity> {

    @Transaction
    @Query("SELECT * FROM profile")
    fun getAllProfileWithNotes():List<ProfileWithNotesEntity>
}