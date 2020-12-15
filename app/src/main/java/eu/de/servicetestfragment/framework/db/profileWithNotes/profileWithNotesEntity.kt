package eu.de.servicetestfragment.framework.db.profileWithNotes

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import eu.de.core.data.note.Note
import eu.de.core.data.profile.Profile

@Entity(tableName = "profileWithNotes")
data class profileWithNotesEntity (
    @Embedded val profile: Profile,
    @Relation(
    parentColumn = "profileId",
    entityColumn = "noteId",
 associateBy = Junction(NoteProfileCrossRef::class)
    )
        val notes: List<Note>
)
{

}