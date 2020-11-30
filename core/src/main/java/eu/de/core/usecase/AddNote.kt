package eu.de.core.usecase

import eu.de.core.data.Note
import eu.de.core.repository.NoteRepository

class AddNote(private val noteRepository:NoteRepository) {

    suspend operator fun invoke(note: Note){
        noteRepository.addNote(note)
    }
}