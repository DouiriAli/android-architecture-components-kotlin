package architecturecomponentkotlin.dialtechnologies.data.room

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */

@Entity(tableName = "users")
data class UserEntity(

        @PrimaryKey(autoGenerate = true)
         var id     : Long = 0,
         var name   : String,
         var avatar : String
)