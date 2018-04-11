package androidachitecturecomponent.example.ui.user

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidachitecturecomponent.example.R
import androidachitecturecomponent.example.data.room.UserEntity
import kotlinx.android.synthetic.main.fragment_users.*

/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */
class UsersFragment : Fragment() {

    private val TAG = UsersFragment::class.java.simpleName

    private var mUserViewModel : UserViewModel ?= null
    private var mAdapter : UserAdapter ?= null

    companion object {

        fun newInstance() : UsersFragment = UsersFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        populate()
    }


    private fun initViews (){

        mAdapter = UserAdapter(activity, arrayListOf<UserEntity>())
        val mLayoutManager = LinearLayoutManager(activity)
        recyclerview.layoutManager = mLayoutManager
        recyclerview.itemAnimator = DefaultItemAnimator()
        recyclerview.adapter = mAdapter

    }

    /**
     * Initialize [UserViewModel]
     */
    private fun initViewModel(){

        mUserViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        mUserViewModel?.let { lifecycle.addObserver(it) }

    }

    /**
     * Show users
     */
    private fun populate() {

        mUserViewModel?.getUsers()?.observe(this,
                Observer {
                    if (it != null) {
                        mAdapter?.setItems(it)
                    }
                })
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}