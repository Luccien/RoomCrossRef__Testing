package eu.de.servicetestfragment.framework.db.noteWithProfiles

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import eu.de.servicetestfragment.framework.db.note.NoteEntity
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.NoteProfileCrossRefEntity
import eu.de.servicetestfragment.framework.db.profile.ProfileEntity

data class NoteWithProfiles (
    @Embedded val noteEntity: NoteEntity,
    @Relation(
        parentColumn = "noteId",
        entityColumn = "profileId",
        associateBy = Junction(NoteProfileCrossRefEntity::class)

    )
    val profileEntities: List<ProfileEntity>
)
{

}
