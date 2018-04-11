package androidachitecturecomponent.example.data.remote

import androidachitecturecomponent.example.data.room.UserEntity
import com.google.gson.annotations.SerializedName


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */
data class UserResponse (

        @SerializedName("login")
        private var mName   : String,
        @SerializedName("avatar_url")
        private var mAvatar : String
){

    fun toUserEntity() =
            UserEntity(0, mName, mAvatar)
}