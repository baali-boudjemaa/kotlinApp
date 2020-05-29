package com.example.kotlinapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinapp.Model.User
import com.example.kotlinapp.R
import com.example.kotlinapp.databinding.RawBinding
import kotlinx.android.synthetic.main.raw.view.*

class UsersAdapter(val users: List<User>): RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding: RawBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.raw, parent, false)

        return UsersViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        return holder.bind(users[position])
    }
}

class UsersViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){



    fun bind(user: User) {
        itemView.apply {
            ids.text = """${user.id}"""
            name.text = user.name }
       // Glide.with(itemView.context).load("http://image.tmdb.org/t/p/w500${movie.poster_path}").into(photo)

    }

}
