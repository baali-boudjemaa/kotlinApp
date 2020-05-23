package com.example.kotlinapp.viewmodel

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinapp.Adapter.UsersAdapter
import com.example.kotlinapp.Model.User
import com.example.kotlinapp.Model.response
import com.example.kotlinapp.Network.APIs
import com.example.kotlinapp.Network.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response


class MainViewModel() : ViewModel() {
    private val compositeDisposable = CompositeDisposable()
    var users = MutableLiveData<List<User>>()

    internal fun fetchAllUsers() : LiveData<List<User>> {
        val api: APIs=RetrofitClient.buildService(APIs::class.java);
        val disposable = api.getAllUsers()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it -> this.onResponses(it) }, this::onFailures)

        compositeDisposable.add(disposable)
        return users;
    }

    // This is called by the Android Activity when the activity is destroyed
    public override fun onCleared() {
        Log.d("GithubActivityViewModel", "onCleared()")
        compositeDisposable.dispose()
        super.onCleared()
    }
    private fun onFailures(t: Throwable) {

    }

    private fun onResponses(response: List<User>) {
        for(a in response){
            println(a.name)
        }
        users.value=response;

    }

}