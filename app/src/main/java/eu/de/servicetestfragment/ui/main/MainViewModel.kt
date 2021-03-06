package eu.de.servicetestfragment.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import eu.de.core.data.note.Note
import eu.de.core.data.noteProfileCrossRef.NoteProfileCrossRef
import eu.de.core.data.profile.Profile
import eu.de.core.repository.note.NoteRepository
import eu.de.core.repository.noteProfileCrossRef.NoteProfileCrossRefRepository
import eu.de.core.repository.profile.ProfileRepository
import eu.de.core.usecase.note.AddNote
import eu.de.core.usecase.note.GetAllNotes
import eu.de.core.usecase.noteProfileCrossRef.AddNoteProfileCrossRef
import eu.de.core.usecase.noteProfileCrossRef.GetAllNoteProfileCrossRef
import eu.de.core.usecase.profile.AddProfile
import eu.de.core.usecase.profile.GetAllProfile
import eu.de.servicetestfragment.framework.db.note.RoomNoteDataSource
import eu.de.servicetestfragment.framework.db.note.NoteUseCases
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.NoteProfileCrossRefUseCases
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.RoomNoteProfileCrossRefDataSource
import eu.de.servicetestfragment.framework.db.noteWithProfiles.NoteWithProfiles
import eu.de.servicetestfragment.framework.db.profile.ProfileUseCases
import eu.de.servicetestfragment.framework.db.profile.RoomProfileDataSource
import eu.de.servicetestfragment.framework.db.profileWithNotes.ProfileWithNotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// --orginal  class MainViewModel : ViewModel() {
class MainViewModel(application: Application): AndroidViewModel(application) {

    val testS by lazy { MutableLiveData<String>() }

    //val roomProfileWithNotesDataSource:RoomProfileWithNotesDataSource =
      //  RoomProfileWithNotesDataSource(application)

    val noteProfileCrossRefRepository =
        NoteProfileCrossRefRepository(
            RoomNoteProfileCrossRefDataSource(
                application
            )
        )

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

// TODO just instead of usecases -- add to usecases
    val roomProfileDataSource =
        RoomProfileDataSource(application)



    val noteProfileCrossRefUseCases = NoteProfileCrossRefUseCases(
        AddNoteProfileCrossRef(noteProfileCrossRefRepository),
        GetAllNoteProfileCrossRef(noteProfileCrossRefRepository)
    )

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
            var listNote:List<Note> = noteUseCases.getAllNotes()
var crossRefList:List<NoteProfileCrossRef> = noteProfileCrossRefUseCases.getAllNoteProfileCrossRef()
            //var list:List<Note> = useCases.getAllNotes()
            var listProfile:List<Profile> = profileUseCases.getAllProfile()
            var test = "fdf"
            //-------- TEST
            ///// shuld be in usecases?? TODO
            //var listProfileWithNotes:List<ProfileWithNotes> = profileUseCases.getAllProfileWithNotes()


            var profileWithNotesList:List<ProfileWithNotes> = roomProfileDataSource.getAllProfileWithNotes()

            var noteWithProfilesList:List<NoteWithProfiles> = roomProfileDataSource.getAllNoteWithProfiles()

            var test2 = "fdf"
//ProfileDao.addEntity
            //addEntity
        }
    }

    fun setInitialNote() {

    }
    fun setInitialNoteOOO() {
        coroutineScope.launch {
            // besser ohne note ide soll ja automatisch!
            val testNote: Note =
                Note("--5677", "h5", 1, 1, 1)
           val testProfile: Profile = Profile("profileTest","des")
            profileUseCases.addProfile(testProfile)

            // a) profile mit id bekommen
//---ok
            // b) note erzeugen
            noteUseCases.addNote(testNote)
            // c) note per id bekommen

            // d) cross reff erzeugen
val testNoteProfileRef:NoteProfileCrossRef = NoteProfileCrossRef(1,1)
            noteProfileCrossRefUseCases.addNoteProfileCrossRef(testNoteProfileRef)

            val testNoteProfileRef2:NoteProfileCrossRef = NoteProfileCrossRef(2,1)
            noteProfileCrossRefUseCases.addNoteProfileCrossRef(testNoteProfileRef2)

            // e) cross ref liste bekommen (profile mit notes)

            // f) selbe note in weiteres profil eintragen

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
