package eu.de.servicetestfragment.framework.db.noteProfileCrossRef

import eu.de.core.usecase.noteProfileCrossRef.AddNoteProfileCrossRef
import eu.de.core.usecase.noteProfileCrossRef.GetAllNoteProfileCrossRef

data class NoteProfileCrossRefUseCases(
    val addNoteProfileCrossRef: AddNoteProfileCrossRef,
    val getAllNoteProfileCrossRef: GetAllNoteProfileCrossRef
) {
}