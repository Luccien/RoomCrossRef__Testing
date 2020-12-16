package eu.de.servicetestfragment.framework.db.profileWithNotes

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import eu.de.core.data.note.Note
import eu.de.core.data.noteProfileCrossRef.NoteProfileCrossRef
import eu.de.core.data.profile.Profile
import eu.de.servicetestfragment.framework.db.note.NoteEntity
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.NoteProfileCrossRefEntity
import eu.de.servicetestfragment.framework.db.profile.ProfileEntity

@Entity(tableName = "profileWithNotes")
data class ProfileWithNotesEntity (
    @Embedded val profile: Profile,
    @Relation(
    parentColumn = "profileId",
    entityColumn = "noteId",
 associateBy = Junction(NoteProfileCrossRefEntity::class)
        //associateBy = Junction(NoteProfileCrossRef::class)

    )
        val notes: List<Note>
)
{

}