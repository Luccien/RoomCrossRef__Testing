package eu.de.servicetestfragment.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import eu.de.core.data.note.Note
import eu.de.core.data.profile.Profile
import eu.de.core.repository.note.NoteRepository
import eu.de.core.repository.profile.ProfileRepository
import eu.de.core.usecase.note.AddNote
import eu.de.core.usecase.note.GetAllNotes
import eu.de.core.usecase.profile.AddProfile
import eu.de.core.usecase.profile.GetAllProfile
import eu.de.servicetestfragment.framework.db.note.RoomNoteDataSource
import eu.de.servicetestfragment.framework.db.note.NoteUseCases
import eu.de.servicetestfragment.framework.db.profile.ProfileUseCases
import eu.de.servicetestfragment.framework.db.profile.RoomProfileDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// --orginal  class MainViewModel : ViewModel() {
class MainViewModel(application: Application): AndroidViewModel(application) {

    val testS by lazy { MutableLiveData<String>() }

    val profileRepository =
        ProfileRepository(
            RoomProfileDataSource(
                application
            )
        )
    val noteRepository =
        NoteRepository(
            RoomNoteDataSource(
                application
            )
        )

    /*
    val roomDataSource =
    RoomNoteDataSource(application)
     */

    val noteUseCases = NoteUseCases(
        AddNote(noteRepository),
        GetAllNotes(noteRepository)
    )

    val profileUseCases = ProfileUseCases(
        AddProfile(profileRepository),
        GetAllProfile(profileRepository)
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

            //var list:List<Note> = useCases.getAllNotes()
            var list:List<Profile> = profileUseCases.getAllProfile()
            var test = "fdf"
        }
    }

    fun setInitialNote(){
        coroutineScope.launch {
            // besser ohne note ide soll ja automatisch!
            val testNote: Note =
                Note("--5677", "h5", 1, 1, 1)
           val testProfile: Profile = Profile("profileTest","des")
            profileUseCases.addProfile(testProfile)
            // 1 ---- original best way
            //noteUseCases.addNote(testNote)
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
