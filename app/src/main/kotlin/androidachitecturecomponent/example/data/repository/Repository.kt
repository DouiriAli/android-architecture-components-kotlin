package androidachitecturecomponent.example.data.repository

import android.arch.lifecycle.LiveData
import androidachitecturecomponent.example.data.room.UserEntity


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */
interface Repository {

    fun getUsersFromDb() : LiveData<List<UserEntity>>

    fun getUsersFromApi()

    fun saveUsers(users : List<UserEntity>)

    fun deleteUsers()
}