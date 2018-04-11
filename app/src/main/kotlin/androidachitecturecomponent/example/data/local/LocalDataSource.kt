package androidachitecturecomponent.example.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import javax.inject.Singleton


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */

@Singleton
@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class LocalDataSource : RoomDatabase() {

    abstract fun getUserDao() : UserDao

}