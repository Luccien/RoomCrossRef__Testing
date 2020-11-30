package eu.de.core.usecase.note

import eu.de.core.data.note.Note
import eu.de.core.repository.note.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note){
        noteRepository.addNote(note)
    }
}