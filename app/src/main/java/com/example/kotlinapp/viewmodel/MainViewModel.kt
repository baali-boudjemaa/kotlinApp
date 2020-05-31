package com.example.kotlinapp.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinapp.Adapter.UsersAdapter
import com.example.kotlinapp.Injection.component.DaggerViewModelInjector
import com.example.kotlinapp.Injection.component.ViewModelInjector
import com.example.kotlinapp.models.User
import com.example.kotlinapp.models.response
import com.example.kotlinapp.Network.APIs
import com.example.kotlinapp.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainViewModel() : ViewModel() {
    private val compositeDisposable = CompositeDisposable()

    val errorClickListener = View.OnClickListener { fetchAllUsers() }
    var users = MutableLiveData<List<User>>()
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    private val injector: ViewModelInjector = DaggerViewModelInjector.builder().build()
init {
    fetchAllUsers();
}
     var usersAdapter:UsersAdapter= UsersAdapter();
    @Inject
    lateinit var api: APIs

    internal fun fetchAllUsers(){
        injector.inject(this)
        val disposable = api.getAllUsers()

            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnSubscribe { onRetrievePostListStart() }
            .doOnTerminate { onRetrieveUsertListFinish() }
            .subscribe(
                {onResponses(it) },
                { onRetrieveUserListError() }
            )

        compositeDisposable.add(disposable)

    }

    // This is called by the Android Activity when the activity is destroyed
    public override fun onCleared() {
        Log.d("GithubActivityViewModel", "onCleared()")
        compositeDisposable.dispose()
        super.onCleared()
    }

    private fun onFailures(t: Throwable) {

    }

    private fun onResponses(response: response) {

        usersAdapter.updateUserList(response.user)
       // users.value = response.user;

    }
    private fun onRetrievePostListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveUsertListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveUserListSuccess(response: response){
        for (i in response.user) println(i.name)

      //  usersAdapter=UsersAdapter(response.user);
        //users.value = response.user;
    }

    private fun onRetrieveUserListError(){
        errorMessage.value = R.string.user_error
    }
}