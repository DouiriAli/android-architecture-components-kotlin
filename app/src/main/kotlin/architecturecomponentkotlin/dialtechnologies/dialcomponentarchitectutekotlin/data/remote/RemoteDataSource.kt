package architecturecomponentkotlin.dialtechnologies.data.remote

import retrofit2.Response
import rx.Observable


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */

class RemoteDataSource constructor(private val remoteService: RemoteService) {

    fun getUsersOnline() : Observable<Response<List<UserResponse>>> = remoteService.getUsersOnline()

}