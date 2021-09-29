package com.retrofitcoroutines.example.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.retrofitcoroutines.example.R
import com.retrofitcoroutines.example.model.User
import com.retrofitcoroutines.example.utils.loadImage
import kotlinx.android.synthetic.main.item_user.view.*

class UserListAdapter(var users: ArrayList<User>): RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    fun updateCountries(newUsers: List<User>) {
        users.clear()
        users.addAll(newUsers)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
    )

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.userAvatar
        private val userName = view.userFullName
        private val userEmail = view.userEmail


        fun bind(user: User) {
            userName.text = user.first_name + " "+ user.last_name
            userEmail.text = user.email
            imageView.loadImage(user.avatar)
        }
    }
}