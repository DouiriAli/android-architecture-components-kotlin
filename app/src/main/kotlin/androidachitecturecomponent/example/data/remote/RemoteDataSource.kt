package androidachitecturecomponent.example.data.remote

import retrofit2.Response
import rx.Observable


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */

class RemoteDataSource constructor(private val remoteService: RemoteService) {

    fun getUsersFromApi() : Observable<Response<List<UserResponse>>> = remoteService.getUsersFromApi()

}