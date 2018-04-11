package androidachitecturecomponent.example.data.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */

@Entity(tableName = "users")
data class UserEntity(

        @PrimaryKey(autoGenerate = true)
         var id     : Long = 0,
         var name   : String,
         var avatar : String
)