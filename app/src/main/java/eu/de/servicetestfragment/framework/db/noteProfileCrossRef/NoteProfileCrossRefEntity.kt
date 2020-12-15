package eu.de.servicetestfragment.framework.db.noteProfileCrossRef

import androidx.room.Entity

@Entity(primaryKeys = ["noteId","profileId"])
data class NoteProfileCrossRefEntity(
    val noteId:Long,
val profileId:Long
) {

}