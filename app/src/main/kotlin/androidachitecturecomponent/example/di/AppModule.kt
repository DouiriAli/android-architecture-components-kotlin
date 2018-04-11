package androidachitecturecomponent.example.di

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import androidachitecturecomponent.example.BuildConfig
import androidachitecturecomponent.example.data.remote.RemoteDataSource
import androidachitecturecomponent.example.data.remote.RemoteService
import androidachitecturecomponent.example.data.repository.RepositoryDataSource
import androidachitecturecomponent.example.data.room.LocalDataSource
import androidachitecturecomponent.example.data.room.UserDao
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by DOUIRI Ali on 16/03/2018.
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
    fun providesRoomDataSource(): LocalDataSource {
        return Room.databaseBuilder(mApplication!!, LocalDataSource::class.java!!, "user_database")
                .build()
    }

    @Singleton
    @Provides
    fun providesUserDao(userRoomDatabase: LocalDataSource): UserDao {
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
    fun providesUserRepository(remoteDataSource: RemoteDataSource, roomDataSource: LocalDataSource): RepositoryDataSource {

        return RepositoryDataSource(remoteDataSource, roomDataSource)
    }
}