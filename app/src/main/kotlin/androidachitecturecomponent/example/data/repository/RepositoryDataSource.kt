package androidachitecturecomponent.example.data.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.NonNull
import android.util.Log
import androidachitecturecomponent.example.data.remote.RemoteDataSource
import androidachitecturecomponent.example.data.room.LocalDataSource
import androidachitecturecomponent.example.data.room.UserEntity
import androidachitecturecomponent.example.utils.Transformation
import rx.Completable
import rx.CompletableSubscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */
class RepositoryDataSource constructor(private val remoteDataSource: RemoteDataSource,
                                       private val roomDataSource: LocalDataSource) : Repository {

    private val TAG : String = RepositoryDataSource::class.java.simpleName

    /**
     * Get users from database
     */
    override fun getUsersFromDb(): LiveData<List<UserEntity>> = roomDataSource.getUserDao().getUsers()

    /**
     * Get users from api
     */
    override fun getUsersFromApi() {

        remoteDataSource.getUsersFromApi()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->

                    Completable.fromAction {
                        deleteUsers()
                        saveUsers(Transformation.toUsersEtities(result.body()!!))
                    }
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(object : CompletableSubscriber {
                                override fun onSubscribe(@NonNull subscription : Subscription) {

                                }

                                override fun onCompleted() {
                                    Log.i(TAG, "DataSource has been Populated")
                                }

                                override fun onError(@NonNull e: Throwable) {
                                    e.printStackTrace()
                                    Log.e(TAG, "DataSource hasn't been Populated")
                                }
                            })

                },
                        { error -> Log.e(TAG, "{$error.message}") },
                        { Log.d(TAG, "completed") })
    }

    /**
     * Save users into database
     */
    override fun saveUsers(users: List<UserEntity>) {

        roomDataSource.getUserDao().saveUsers(users)
    }

    /**
     * Delete all users
     */
    override fun deleteUsers() {

        roomDataSource.getUserDao().deleteUsers()
    }
}

