package androidachitecturecomponent.example.data.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */
@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getUsers() : LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveUsers(users : List<UserEntity>)

    @Query("DELETE FROM users")
    fun deleteUsers()
}