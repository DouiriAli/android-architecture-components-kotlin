package architecturecomponentkotlin.dialtechnologies.data.remote

import retrofit2.Response
import retrofit2.http.GET
import rx.Observable


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */
interface RemoteService {

    @GET("users")
    fun getUsersOnline() : Observable<Response<List<UserResponse>>>
}