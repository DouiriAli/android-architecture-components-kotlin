package androidachitecturecomponent.example

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import androidachitecturecomponent.example.data.repository.RepositoryDataSource
import androidachitecturecomponent.example.di.AppComponent
import androidachitecturecomponent.example.di.AppModule
import androidachitecturecomponent.example.di.DaggerAppComponent
import javax.inject.Inject


/**
 * Created by DOUIRI Ali on 16/03/2018.
 * my.alidouiri@gmail.com
 */
class App : Application () {

    @Inject
    lateinit var mRepositoryDataSource : RepositoryDataSource

    companion object {

        lateinit var mAppComponent: AppComponent
    }

    init {

        initializeDagger()
    }

    override fun onCreate() {
        super.onCreate()

        mAppComponent.inject(this)

        //Get users from api
        mRepositoryDataSource.getUsersFromApi()
    }

    /**
     * Initialize AppComponent
     */
    fun initializeDagger (){

        mAppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}