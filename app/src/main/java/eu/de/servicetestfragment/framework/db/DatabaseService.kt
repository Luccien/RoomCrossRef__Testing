package eu.de.servicetestfragment.framework.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import eu.de.servicetestfragment.framework.db.note.NoteDao
import eu.de.servicetestfragment.framework.db.note.NoteEntity
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.NoteProfileCrossRefDao
import eu.de.servicetestfragment.framework.db.noteProfileCrossRef.NoteProfileCrossRefEntity
import eu.de.servicetestfragment.framework.db.profile.ProfileDao
import eu.de.servicetestfragment.framework.db.profile.ProfileEntity

// TODO cut out , ProfileWithNotesEntity::class
@Database(entities = [NoteEntity::class, ProfileEntity::class, NoteProfileCrossRefEntity::class], version= 11)
abstract class DatabaseService : RoomDatabase(){

    companion object {

        private const val DATABASE_NAME = "note.db"

        private var instance: DatabaseService? = null

        private fun create(context: Context): DatabaseService =
            Room.databaseBuilder(context, DatabaseService::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()


        fun getInstance(context: Context): DatabaseService =
            (instance
                ?: create(
                    context
                )).also { instance = it }
    }

    abstract fun noteDao(): NoteDao
    abstract fun profileDao(): ProfileDao
    abstract fun noteProfileCrossRefDao(): NoteProfileCrossRefDao
   // abstract fun profileWithNotesDao(): ProfileWithNotesDao
}