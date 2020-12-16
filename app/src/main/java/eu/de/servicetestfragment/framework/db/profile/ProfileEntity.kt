package eu.de.servicetestfragment.framework.db.profile

import androidx.room.Entity
import androidx.room.PrimaryKey
import eu.de.core.data.profile.Profile

@Entity(tableName = "profile")
data class ProfileEntity(
   val name:String,
    val description:String,
    @PrimaryKey//////// TODO LEAVE OUT FOR TESTING (autoGenerate = true)
    val profileId:Long = 0L

) {
    companion object{
        // id is autogenerated from Entity -> id not passed
        fun fromProfile(profile:Profile):ProfileEntity = ProfileEntity(profile.name,profile.description)

    }

    fun toProfile():Profile = Profile(name,description,profileId)

}