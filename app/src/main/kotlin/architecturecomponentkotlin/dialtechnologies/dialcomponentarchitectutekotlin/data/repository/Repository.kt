package architecturecomponentkotlin.dialtechnologies.data.repository

import android.arch.lifecycle.LiveData
import architecturecomponentkotlin.dialtechnologies.data.room.UserEntity


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */
interface Repository {

    fun getUsersDb() : LiveData<List<UserEntity>>

    fun getUsersOnline()

    fun saveUsersDb(users : List<UserEntity>)

    fun deleteUsersDb()
}