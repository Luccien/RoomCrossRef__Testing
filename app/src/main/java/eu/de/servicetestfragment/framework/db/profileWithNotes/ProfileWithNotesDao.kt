package eu.de.servicetestfragment.framework.db.profileWithNotes

import androidx.room.Dao
import androidx.room.Query
import eu.de.servicetestfragment.framework.db.BaseDao

@Dao
interface ProfileWithNotesDao : BaseDao<ProfileWithNotesEntity> {

    @Query("SELECT * FROM profileWithNotes")
    fun getAllProfileWithNotes():List<ProfileWithNotesEntity>
}