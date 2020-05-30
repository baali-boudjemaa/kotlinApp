package com.example.kotlinapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.models.User
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.RawBinding
import kotlinx.android.synthetic.main.raw.view.*

class UsersAdapter() : RecyclerView.Adapter<UsersViewHolder>() {
    lateinit var users: List<User>;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: RawBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.raw,
            parent,
            false
        )

        return UsersViewHolder(binding)
    }

    fun updateUserList(users: List<User>):UsersAdapter {
        this.users = users
        return this
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
         holder.bind(users[position])
    }
}

class UsersViewHolder(val binding : RawBinding) : RecyclerView.ViewHolder(binding.root) {

     // var tc:TextView=itemView.tc

    fun bind(user: User) {

        binding.apply {
            println(user.uid)
            tc.text=user.uid
            iid = user.ids.toString()
           names = user.name
        }
        // Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)

    }

}
