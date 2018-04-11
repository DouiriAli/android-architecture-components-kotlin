package androidachitecturecomponent.example.di

import androidachitecturecomponent.example.App
import androidachitecturecomponent.example.ui.user.UserViewModel
import dagger.Component
import javax.inject.Singleton


/**
 * Created by DOUIRI Ali on 16/03/2018.
 * my.alidouiri@gmail.com
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject (viewModel : UserViewModel)

    fun inject (dialApp : App)
}