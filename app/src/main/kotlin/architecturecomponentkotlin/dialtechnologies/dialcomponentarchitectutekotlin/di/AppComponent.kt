package architecturecomponentkotlin.dialtechnologies.di

import architecturecomponentkotlin.dialtechnologies.DialApp
import architecturecomponentkotlin.dialtechnologies.ui.user.UserViewModel
import dagger.Component
import javax.inject.Singleton


/**
 * Created by DOUIRI Ali on 16/03/2018.
 * Dial Technologies
 * a.douiri@dialy.net
 * my.alidouiri@gmail.com
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject (viewModel : UserViewModel)

    fun inject (dialApp : DialApp)
}