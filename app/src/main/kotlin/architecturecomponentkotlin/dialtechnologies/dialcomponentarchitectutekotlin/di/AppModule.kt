package architecturecomponentkotlin.dialtechnologies.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import architecturecomponentkotlin.dialtechnologies.data.remote.RemoteDataSource
import architecturecomponentkotlin.dialtechnologies.data.remote.RemoteService
import architecturecomponentkotlin.dialtechnologies.data.repository.RepositoryDataSource
import architecturecomponentkotlin.dialtechnologies.data.room.RoomDataSource
import architecturecomponentkotlin.dialtechnologies.data.room.UserDao
import architecturecomponentkotlin.dialtechnologies.dialcomponentarchitectutekotlin.BuildConfig
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by DOUIRI Ali on 16/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */

@Module
@Singleton
class AppModule {

    var mApplication : Application ?= null

    constructor(application : Application) {

        mApplication = application
    }

    @Singleton
    @Provides
    fun providesRoomDataSource(): RoomDataSource {
        return Room.databaseBuilder(mApplication!!, RoomDataSource::class.java!!, "user_database")
                .build()
    }

    @Singleton
    @Provides
    fun providesUserDao(userRoomDatabase: RoomDataSource): UserDao {
        return userRoomDatabase.getUserDao()
    }

    @Provides
    fun providesAppContext(): Context {
        return mApplication!!
    }

    @Provides
    @Singleton
    fun providesRemoteService(): RemoteService {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RemoteService::class.java!!)
    }

    @Provides
    @Singleton
    fun providesRemoteDataSource(remoteService: RemoteService): RemoteDataSource {
        return RemoteDataSource(remoteService)
    }

    @Provides
    @Singleton
    fun providesUserRepository(remoteDataSource: RemoteDataSource, roomDataSource: RoomDataSource): RepositoryDataSource {

        return RepositoryDataSource(remoteDataSource, roomDataSource)
    }
}