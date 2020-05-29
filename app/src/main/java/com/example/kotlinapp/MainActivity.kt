package com.example.kotlinapp

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.Adapter.UsersAdapter
import com.example.kotlinapp.Model.User
import com.example.kotlinapp.Model.response
import com.example.kotlinapp.databinding.ActivityMainBinding
import com.example.kotlinapp.viewmodel.MainViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var   binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil. setContentView(this, R.layout.activity_main)

        var mainViewModel: MainViewModel =
            ViewModelProviders.of(this).get(MainViewModel::class.java);
        binding.viewModel = mainViewModel

        mainViewModel.fetchAllUsers().observe(this, Observer<List<User>>() {
            recyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter =UsersAdapter(it)
            }
        })
//        recyclerView.adapter = UsersAdapter(mainViewModel.users.value!!)


    }
}
