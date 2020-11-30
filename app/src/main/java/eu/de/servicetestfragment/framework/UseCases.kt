package eu.de.servicetestfragment.framework

import eu.de.core.usecase.AddNote
import eu.de.core.usecase.GetAllNotes

data class UseCases (
    val addNote: AddNote,
    val getAllNotes: GetAllNotes
){
}