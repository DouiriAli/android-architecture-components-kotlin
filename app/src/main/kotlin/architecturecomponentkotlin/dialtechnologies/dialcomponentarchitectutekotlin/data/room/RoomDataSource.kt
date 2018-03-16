package architecturecomponentkotlin.dialtechnologies.data.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import javax.inject.Singleton


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */

@Singleton
@Database(entities = arrayOf(UserEntity::class), version = 1)
abstract class RoomDataSource : RoomDatabase() {

    abstract fun getUserDao() : UserDao

}