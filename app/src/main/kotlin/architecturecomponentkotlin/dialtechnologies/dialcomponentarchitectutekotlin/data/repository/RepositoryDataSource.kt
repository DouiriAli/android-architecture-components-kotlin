package architecturecomponentkotlin.dialtechnologies.data.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.NonNull
import android.util.Log
import architecturecomponentkotlin.dialtechnologies.data.remote.RemoteDataSource
import architecturecomponentkotlin.dialtechnologies.data.room.RoomDataSource
import architecturecomponentkotlin.dialtechnologies.data.room.UserEntity
import architecturecomponentkotlin.dialtechnologies.utils.Transformation
import rx.Completable
import rx.CompletableSubscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */
class RepositoryDataSource constructor(private val remoteDataSource: RemoteDataSource,
                                       private val roomDataSource: RoomDataSource) : Repository {

    private val TAG : String = RepositoryDataSource::class.java.simpleName

    override fun getUsersDb(): LiveData<List<UserEntity>> = roomDataSource.getUserDao().getUsersDb()

    override fun getUsersOnline() {

        remoteDataSource.getUsersOnline()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->

                    Completable.fromAction {
                        deleteUsersDb()
                        saveUsersDb(Transformation.toUsersEtities(result.body()!!))
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

    override fun saveUsersDb(users: List<UserEntity>) {

        roomDataSource.getUserDao().saveUsersDb(users)
    }

    override fun deleteUsersDb() {

        roomDataSource.getUserDao().deleteUsersDb()
    }
}

