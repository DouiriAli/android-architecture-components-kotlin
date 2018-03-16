package architecturecomponentkotlin.dialtechnologies

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex
import architecturecomponentkotlin.dialtechnologies.data.repository.RepositoryDataSource
import architecturecomponentkotlin.dialtechnologies.di.AppComponent
import architecturecomponentkotlin.dialtechnologies.di.AppModule
import architecturecomponentkotlin.dialtechnologies.di.DaggerAppComponent
import dagger.Component
import javax.inject.Inject


/**
 * Created by DOUIRI Ali on 16/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */
class DialApp : Application () {

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

        mRepositoryDataSource!!.getUsersOnline()
    }

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