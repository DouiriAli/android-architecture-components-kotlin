package architecturecomponentkotlin.dialtechnologies.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import architecturecomponentkotlin.dialtechnologies.dialcomponentarchitectutekotlin.R
import architecturecomponentkotlin.dialtechnologies.ui.user.UsersFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null)
            replaceFragment(UsersFragment.newInstance())

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit()
    }
}
