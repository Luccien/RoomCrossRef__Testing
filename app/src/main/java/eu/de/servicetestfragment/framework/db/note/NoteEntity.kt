package eu.de.servicetestfragment.framework.db.note

import androidx.room.Entity
import androidx.room.PrimaryKey
import eu.de.core.data.note.Note

@Entity(tableName = "note")
data class NoteEntity (

    // wieso hier val in entity und var in Note?
    val title:String,
    var content: String,
    var creationTime: Long,
    var updateTime: Long,

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L//,

    //var wordCount: Int = 0
){
    companion object{
        // no private (does it matter?)
        fun fromNote(note: Note) =
            NoteEntity(
                note.title,
                note.content,
                note.creationTime,
                note.updateTime
            )
    }
    // no private ???  //// --> here id is passed because it is generated
    fun toNote() =
        Note(title, content, creationTime, updateTime, id)
}