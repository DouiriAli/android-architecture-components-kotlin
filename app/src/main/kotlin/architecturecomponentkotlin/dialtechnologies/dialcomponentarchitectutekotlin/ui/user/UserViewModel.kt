package architecturecomponentkotlin.dialtechnologies.ui.user

import android.arch.lifecycle.*
import architecturecomponentkotlin.dialtechnologies.DialApp
import architecturecomponentkotlin.dialtechnologies.data.repository.RepositoryDataSource
import architecturecomponentkotlin.dialtechnologies.data.room.UserEntity
import javax.inject.Inject


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */
class UserViewModel : ViewModel(), LifecycleObserver {

    private val TAG : String ?= UserViewModel::class.simpleName

    @Inject
    lateinit var mRepositoryDataSource : RepositoryDataSource

    init {

        DialApp.mAppComponent.inject(this)
    }

    fun getUsers() : LiveData<List<UserEntity>> = mRepositoryDataSource.getUsersDb()

}