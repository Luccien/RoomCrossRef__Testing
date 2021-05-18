package eu.de.core.usecase.note

import eu.de.core.data.note.Note
import eu.de.core.repository.note.NoteRepository

class GetAllNotes (private val noteRepository: NoteRepository){

    suspend operator fun invoke():List<Note>{
       return noteRepository.getAllNote()
    }


}