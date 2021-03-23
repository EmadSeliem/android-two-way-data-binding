package com.kotlin.databindingsample.data

import android.app.Application
import android.content.Context
import android.util.Log.v
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * A VM for [com.kotlin.databindingsample.ui.LoginActivity]
 */

class LoginActivityViewModel : ViewModel() {

    var userName: MutableLiveData<String> = MutableLiveData("")
    var password: MutableLiveData<String> = MutableLiveData("")
    var rememberMe: MutableLiveData<Boolean> = MutableLiveData(false)

    // passwordValidation is exposed as alive data .

    val passwordValidation: LiveData<PasswordValidationCriteria> =
        Transformations.map(password) {
            when (it.length) {
                in 1..4 -> PasswordValidationCriteria.SHORT_PASSWORD
                in 15..20 -> PasswordValidationCriteria.LONG_PASSWORD
                else -> PasswordValidationCriteria.VALID_PASSWORD
            }
        }


    // usernameValidation is exposed as alive data .
    val usernameValidation: LiveData<UsernameValidationCriteria> = Transformations.map(userName) {
        when (it.length) {
            in 1..4 -> UsernameValidationCriteria.SHORT_USERNAME
            in 15..20 -> UsernameValidationCriteria.LONG_USERNAME
            else -> UsernameValidationCriteria.VALID_USERNAME
        }
    }

    fun onLoginClick() {
        /**
         * Using two way data binding you can use rememberMe value to do your logic.
         * You can use it to cache on shared preference.
         */
        v("Remember me", "${rememberMe.value.toString()}");
    }

    /**
     * Creating an enum with password validation criteria.
     * You can easy add more validation criteria for username and password.
     */
    enum class PasswordValidationCriteria {
        SHORT_PASSWORD, LONG_PASSWORD, VALID_PASSWORD
    }

    enum class UsernameValidationCriteria {
        SHORT_USERNAME, LONG_USERNAME, VALID_USERNAME
    }
}