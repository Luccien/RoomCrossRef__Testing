package eu.de.servicetestfragment.framework.db.profileWithNotes

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Junction
import androidx.room.Relation
import eu.de.core.data.note.Note
import eu.de.core.data.profile.Profile
import eu.de.servicetestfragment.framework.db.note.NoteEntity
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.NoteProfileCrossRefEntity
import eu.de.servicetestfragment.framework.db.profile.ProfileEntity

@Entity(tableName = "profileWithNotes")
data class ProfileWithNotesEntity (
    @Embedded val profileEntity: ProfileEntity,
    @Relation(
    parentColumn = "profileId",
    entityColumn = "noteId",
 associateBy = Junction(NoteProfileCrossRefEntity::class)
    )
        val notes: List<NoteEntity>
)
{

}