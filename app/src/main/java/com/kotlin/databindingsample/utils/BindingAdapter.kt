package com.kotlin.databindingsample.utils

import androidx.databinding.BindingAdapter
import com.google.android.material.textfield.TextInputLayout
import com.kotlin.databindingsample.R
import com.kotlin.databindingsample.data.LoginActivityViewModel


object BindingAdapter {
    /**
     * A Binding Adapter that is called whenever the value of the attribute `validatePassword`
     * changes. Receives a text that determines to display error or not.
     */

    @JvmStatic
    @BindingAdapter("validatePassword")
    fun validatePassword(
        passwordTextInputLayout: TextInputLayout,
        passwordValidation: LoginActivityViewModel.PasswordValidationCriteria
    ) {
        when (passwordValidation) {
            LoginActivityViewModel.PasswordValidationCriteria.SHORT_PASSWORD ->
                passwordTextInputLayout.error =
                    passwordTextInputLayout.context.getString(R.string.error_password_short)

            LoginActivityViewModel.PasswordValidationCriteria.LONG_PASSWORD ->
                passwordTextInputLayout.error =
                    passwordTextInputLayout.context.getString(R.string.error_password_long)

            else -> passwordTextInputLayout.error = null
        }

    }

    @JvmStatic
    @BindingAdapter("validateUserName")
    fun validateUserName(
        userNameTextInputLayout: TextInputLayout,
        userNameValidation: LoginActivityViewModel.UsernameValidationCriteria
    ) {
        when (userNameValidation) {
            LoginActivityViewModel.UsernameValidationCriteria.SHORT_USERNAME ->
                userNameTextInputLayout.error =
                    userNameTextInputLayout.context.getString(R.string.error_username_short)
            LoginActivityViewModel.UsernameValidationCriteria.LONG_USERNAME ->
                userNameTextInputLayout.error =
                    userNameTextInputLayout.context.getString(R.string.error_username_long)
            else -> userNameTextInputLayout.error = null
        }
    }
}