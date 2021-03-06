package eu.de.servicetestfragment.framework.db.noteProfileCrossRef

import androidx.room.Dao
import androidx.room.Query
import eu.de.servicetestfragment.framework.db.BaseDao

@Dao
interface NoteProfileCrossRefDao : BaseDao<NoteProfileCrossRefEntity> {

    @Query("SELECT * FROM noteProfileCrossRef")
    fun getAllNoteProfileCrossRef():List<NoteProfileCrossRefEntity>
}