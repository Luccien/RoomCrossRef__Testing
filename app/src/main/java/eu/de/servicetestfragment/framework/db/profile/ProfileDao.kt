package eu.de.servicetestfragment.framework.db.profile

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import eu.de.servicetestfragment.framework.db.BaseDao
import eu.de.servicetestfragment.framework.db.noteWithProfiles.NoteWithProfiles
import eu.de.servicetestfragment.framework.db.profileWithNotes.ProfileWithNotes

@Dao
interface ProfileDao: BaseDao<ProfileEntity> {

    @Query("SELECT * FROM profile WHERE profileId = :id")
    fun getProfile(id:Long):ProfileEntity

    @Query("SELECT * FROM profile")
    fun getAllProfile():List<ProfileEntity>

    @Transaction
    @Query("SELECT * FROM profile")
    fun getAllProfileWithNotes():List<ProfileWithNotes>

    @Transaction
    @Query("SELECT * FROM note")
    fun getAllNoteWithProfiles():List<NoteWithProfiles>


}