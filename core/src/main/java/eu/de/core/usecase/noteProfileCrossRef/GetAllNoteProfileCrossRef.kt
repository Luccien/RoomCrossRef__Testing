package eu.de.core.usecase.noteProfileCrossRef

import eu.de.core.data.noteProfileCrossRef.NoteProfileCrossRef
import eu.de.core.repository.noteProfileCrossRef.NoteProfileCrossRefRepository

class GetAllNoteProfileCrossRef (private val noteProfileCrossRefRepository: NoteProfileCrossRefRepository) {
    suspend operator fun invoke():List<NoteProfileCrossRef> = noteProfileCrossRefRepository.getAllNoteProfileCrossRef()

}