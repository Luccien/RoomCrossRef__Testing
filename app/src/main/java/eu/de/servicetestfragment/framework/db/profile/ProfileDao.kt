package eu.de.servicetestfragment.framework.db.profile

import androidx.room.Dao
import androidx.room.Query
import eu.de.servicetestfragment.framework.db.BaseDao

@Dao
interface ProfileDao: BaseDao<ProfileEntity> {

    @Query("SELECT * FROM profile WHERE profileId = :id")
    fun getProfile(id:Long):ProfileEntity

    @Query("SELECT * FROM profile")
    fun getAllProfile():List<ProfileEntity>

}