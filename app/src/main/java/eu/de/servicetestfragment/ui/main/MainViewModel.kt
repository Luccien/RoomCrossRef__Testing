package eu.de.servicetestfragment.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import eu.de.core.data.note.Note
import eu.de.core.repository.note.NoteRepository
import eu.de.core.usecase.note.AddNote
import eu.de.core.usecase.note.GetAllNotes
import eu.de.servicetestfragment.framework.db.note.RoomNoteDataSource
import eu.de.servicetestfragment.framework.db.note.NoteUseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// --orginal  class MainViewModel : ViewModel() {
class MainViewModel(application: Application): AndroidViewModel(application) {

    val testS by lazy { MutableLiveData<String>() }

    /// WIESO SO??? NICHT EINFACH ohne NoteRepository --UNTERSCHIED SOURCE (wieso 2 ??)
    val repository =
        NoteRepository(
            RoomNoteDataSource(
                application
            )
        )
val roomDataSource =
    RoomNoteDataSource(application)

    val useCases = NoteUseCases(
        AddNote(repository),
        GetAllNotes(repository)

    )


    fun refresh(){
        //testS.value += "Hallo Mutable"
        testS.value +="A"
        println(testS.value.toString())
        println("REFRESH OK 2 ")

    }

    //var useCases: UseCases = UseCases()
    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    fun testInitialNote(){
        coroutineScope.launch {
           // val testNote: Note = Note("--1","c1",1,1,1)
            var list:List<Note> = useCases.getAllNotes()
            var test = "fdf"
        }
    }

    fun setInitialNote(){
        coroutineScope.launch {
            val testNote: Note =
                Note("--5", "h5", 1, 1, 1)

            // 1 ---- original best way
            useCases.addNote(testNote)
            //------

            // 2 --- works directly call usescases
            //val adNote:AddNote = AddNote(repository)
            //adNote(testNote)
            // --------

            //3 ----- call repository directly
            //repository.addNote(testNote)
            // -------

            //4 --- repository ganz weg direkt die datensource ansprechen
            //roomDataSource.add(testNote)
            //--------

        }
    }



}
