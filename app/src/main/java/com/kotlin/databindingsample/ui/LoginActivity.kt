package com.kotlin.databindingsample.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.kotlin.databindingsample.R
import com.kotlin.databindingsample.data.LoginActivityViewModel
import com.kotlin.databindingsample.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    val loginViewModel: LoginActivityViewModel by lazy {
        ViewModelProviders.of(this).get(LoginActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataBinding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        dataBinding.lifecycleOwner = this
        dataBinding.loginViewModel = loginViewModel
    }
}