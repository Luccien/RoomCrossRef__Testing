package eu.de.servicetestfragment.framework.db.note

import eu.de.core.usecase.note.AddNote
import eu.de.core.usecase.note.GetAllNotes

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes
){
}