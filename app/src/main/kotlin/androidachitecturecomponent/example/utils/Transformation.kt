package androidachitecturecomponent.example.utils

import androidachitecturecomponent.example.data.remote.UserResponse
import androidachitecturecomponent.example.data.room.UserEntity

/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 *
 *
 * This class makes it possible to transform response of api to [UserEntity]
 *
 */
class Transformation {

    companion object {

        fun toUsersEtities(usersResponse: List<UserResponse>): List<UserEntity> = usersResponse.map { it.toUserEntity() }

    }
}
