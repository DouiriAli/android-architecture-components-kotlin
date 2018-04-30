package androidachitecturecomponent.example.ui.user

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidachitecturecomponent.example.R
import androidachitecturecomponent.example.data.room.UserEntity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_view.view.*


/**
 * Created by DOUIRI Ali on 15/03/2018.
 * my.alidouiri@gmail.com
 */

class UserAdapter (private var context : Context ? , private var users : List<UserEntity>) :
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_view, parent, false)
        return ViewHolder(v)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder?.mName?.text = users[position].name
        Glide.with(context).asBitmap().load(users[position].avatar).into(holder?.mAvatar)

    }

    override fun getItemCount(): Int = users?.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val mName = itemView.name
        val mAvatar = itemView.avatar

    }

    fun setItems(users : List<UserEntity>) {

        this.users = users
        notifyDataSetChanged()
    }
}