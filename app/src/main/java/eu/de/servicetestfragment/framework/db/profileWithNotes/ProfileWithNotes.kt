package eu.de.servicetestfragment.framework.db.profileWithNotes

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import eu.de.servicetestfragment.framework.db.note.NoteEntity
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.NoteProfileCrossRefEntity
import eu.de.servicetestfragment.framework.db.profile.ProfileEntity

data class ProfileWithNotes (
    @Embedded val profileEntity: ProfileEntity,
    @Relation(
    parentColumn = "profileId",
    entityColumn = "noteId",
 associateBy = Junction(NoteProfileCrossRefEntity::class)
        //associateBy = Junction(NoteProfileCrossRef::class)

    )
        val noteEntities: List<NoteEntity>
)
{

}