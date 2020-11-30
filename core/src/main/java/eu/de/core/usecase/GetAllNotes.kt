package eu.de.core.usecase

import eu.de.core.data.Note
import eu.de.core.repository.NoteRepository

class GetAllNotes (private val noteRepository: NoteRepository){

    suspend operator fun invoke():List<Note>{
       return noteRepository.getAllNote()
    }


}