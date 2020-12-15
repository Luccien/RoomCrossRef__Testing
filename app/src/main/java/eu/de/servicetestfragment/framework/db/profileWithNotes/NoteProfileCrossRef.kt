package eu.de.servicetestfragment.framework.db.profileWithNotes

import androidx.room.Entity

@Entity(primaryKeys = ["noteId","profileId"])
data class NoteProfileCrossRef(
    val noteId:Long,
val profileId:Long
) {

}