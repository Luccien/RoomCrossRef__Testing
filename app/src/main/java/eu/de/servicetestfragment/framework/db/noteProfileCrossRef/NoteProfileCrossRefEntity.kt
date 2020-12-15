package eu.de.servicetestfragment.framework.db.noteProfileCrossRef

import androidx.room.Entity
import eu.de.core.data.noteProfileCrossRef.NoteProfileCrossRef

@Entity(primaryKeys = ["noteId","profileId"],tableName = "noteProfileCrossRef")
data class NoteProfileCrossRefEntity(
    val noteId:Long,
val profileId:Long
) {
    companion object{
        fun fromNoteProfileCrossRef(noteProfileCrossRef: NoteProfileCrossRef):NoteProfileCrossRefEntity = NoteProfileCrossRefEntity(noteProfileCrossRef.noteId,noteProfileCrossRef.profileId)
    }
    fun toNoteProfileCrossRef():NoteProfileCrossRef = NoteProfileCrossRef(noteId,profileId)

}