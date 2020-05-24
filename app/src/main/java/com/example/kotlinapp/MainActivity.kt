package com.example.kotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlinapp.Adapter.UsersAdapter
import com.example.kotlinapp.Model.User
import com.example.kotlinapp.viewmodel.MainViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var mainViewModel: MainViewModel =
            ViewModelProviders.of(this).get(MainViewModel::class.java);

        mainViewModel.fetchAllUsers().observe(this, Observer<List<User>>() {
            var users: List<User>
            users=it
            recyclerView.adapter = UsersAdapter(it)
        }).apply {
        }
//        recyclerView.adapter = UsersAdapter(mainViewModel.users.value!!)


    }
}
