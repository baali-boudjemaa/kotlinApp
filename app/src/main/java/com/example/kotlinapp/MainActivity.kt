package com.example.kotlinapp

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.DividerItemDecoration.VERTICAL
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.Adapter.UsersAdapter
import com.example.kotlinapp.databinding.ActivityMainBinding
import com.example.kotlinapp.models.User
import com.example.kotlinapp.viewmodel.MainViewModel
import com.example.kotlinapp.viewmodel.ViewModelFactory
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    lateinit var   binding : ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var errorSnackbar: Snackbar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil. setContentView(this, R.layout.activity_main)

        var mainViewModel: MainViewModel = ViewModelProviders.of(this, ViewModelFactory(this)).get(MainViewModel::class.java)

        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val decoration =
            DividerItemDecoration(applicationContext, VERTICAL)
        binding.recyclerView.addItemDecoration(decoration)
       // recyclerView.
       /* mainViewModel.fetchAllUsers().observe(this, Observer<List<User>>() {
           *//* recyclerView.apply {
                addItemDecoration(decoration)
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter =UsersAdapter().updateUserList(it)
            }*//*
        })*/
//        recyclerView.adapter = UsersAdapter(mainViewModel.users.value!!)

        mainViewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = mainViewModel;
        //binding.viewModel = mainViewModel
    }
    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}
