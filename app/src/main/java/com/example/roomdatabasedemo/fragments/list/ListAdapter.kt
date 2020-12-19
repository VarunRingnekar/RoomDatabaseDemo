package com.example.roomdatabasedemo.fragments.list

import android.util.Log.i
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabasedemo.data.User
import android.view.View
import com.example.roomdatabasedemo.R
import kotlinx.android.synthetic.main.custom_row.view.*

//adapter for recycler view (sorry, I skipped this in the session)
//please go through the tracks before trying to understand this code

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    //inflates custom layout i.e custom_row.xml as a viewHolder for recycler view i.e every entry in the recycler view
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    //puts the respective user data at position in recycler view and binds it to the view holder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.id_tv.text = currentItem.id.toString()
        holder.itemView.firstName_tv.text = currentItem.firstName.toString()
        holder.itemView.lastName_tv.text = currentItem.lastName.toString()
        holder.itemView.age_tv.text = currentItem.age.toString()
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    //gets the users list from list fragment which in turn gets it from the database
    fun setData(users: List<User>){
        this.userList = users
        notifyDataSetChanged()
    }
}