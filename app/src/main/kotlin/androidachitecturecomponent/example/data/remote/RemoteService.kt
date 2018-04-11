package androidachitecturecomponent.example.data.remote

import retrofit2.Response
import retrofit2.http.GET
import rx.Observable


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */
interface RemoteService {

    @GET("users")
    fun getUsersFromApi() : Observable<Response<List<UserResponse>>>
}