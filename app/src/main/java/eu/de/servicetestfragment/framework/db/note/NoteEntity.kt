package eu.de.servicetestfragment.framework.db.note

import androidx.room.Entity
import androidx.room.PrimaryKey
import eu.de.core.data.note.Note

@Entity(tableName = "note")
data class NoteEntity (

    val title:String,
    var content: String,
    var creationTime: Long,
    var updateTime: Long,
    var noteProfileId: Long,

    @PrimaryKey(autoGenerate = true)
    var noteId: Long = 0L//,

    //var wordCount: Int = 0
){
    companion object{
        fun fromNote(note: Note) =
            NoteEntity(
                note.title,
                note.content,
                note.creationTime,
                note.updateTime,
                note.noteProfileId
            )
    }
    fun toNote() =
        Note(title, content, creationTime, updateTime,noteProfileId, noteId)
}