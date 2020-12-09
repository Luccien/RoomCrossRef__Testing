package eu.de.core.data.note

data class Note(
  var title:String,
  var content: String,
  var creationTime: Long,
  var updateTime: Long,
  var noteId: Long = 0//,
)
