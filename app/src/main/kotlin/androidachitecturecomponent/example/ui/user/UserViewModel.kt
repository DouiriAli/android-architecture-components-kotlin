package androidachitecturecomponent.example.ui.user

import android.arch.lifecycle.*
import androidachitecturecomponent.example.App
import androidachitecturecomponent.example.data.repository.RepositoryDataSource
import androidachitecturecomponent.example.data.room.UserEntity
import javax.inject.Inject


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */
class UserViewModel : ViewModel(), LifecycleObserver {

    private val TAG : String ?= UserViewModel::class.simpleName

    @Inject
    lateinit var mRepositoryDataSource : RepositoryDataSource

    init {

        App.mAppComponent.inject(this)
    }


    /**
     * Get users from database
     */
    fun getUsers() : LiveData<List<UserEntity>> = mRepositoryDataSource.getUsersFromDb()

}