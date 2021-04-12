package com.example.baitaptuan1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.baitaptuan1.LoginTableModel
import com.example.baitaptuan1.LoginRepository


class LoginViewModel : ViewModel() {
    var liveDataLogin: LiveData<LoginTableModel>? = null

    fun insertData(context: Context, email: String, password: String) {
        LoginRepository.insertData(context, email, password)
    }

    fun getLoginDetails(context: Context, email: String) : LiveData<LoginTableModel>? {
        liveDataLogin = LoginRepository.getLoginDetails(context, email)
        return liveDataLogin
    }
}