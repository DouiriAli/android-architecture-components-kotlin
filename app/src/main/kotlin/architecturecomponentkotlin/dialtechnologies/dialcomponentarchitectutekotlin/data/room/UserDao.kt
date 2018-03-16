package architecturecomponentkotlin.dialtechnologies.data.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsersDb() : LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUsersDb(users : List<UserEntity>)

    @Query("DELETE FROM users")
    fun deleteUsersDb()
}