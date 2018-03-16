package architecturecomponentkotlin.dialtechnologies.utils

import architecturecomponentkotlin.dialtechnologies.data.remote.UserResponse
import architecturecomponentkotlin.dialtechnologies.data.room.UserEntity

/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */

class Transformation {

    companion object {

        fun toUsersEtities(usersResponse: List<UserResponse>): List<UserEntity> = usersResponse.map { it.toUserEntity() }

    }
}
