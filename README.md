# two-way-data-binding

Login screen is one of the most importants screens that most of applications have, usually we need avlidations on fileds and before we are using textwacthers 
to listen for changes on EditText and dispaly errors on TextInputLayout.

So I created this sample project to explian how we can do validations for different views using two way data binind and Binding adapters.

*First validation is on username and password , if user enters short password with less than 4 characters then error will be displayed,
If he enters password with length between 15 and 20 another error will be dispalyed otherwise password will be valid .
    
    when (it.length) {
                in 1..4 -> PasswordValidationCriteria.SHORT_PASSWORD
                in 15..20 -> PasswordValidationCriteria.LONG_PASSWORD
                else -> PasswordValidationCriteria.VALID_PASSWORD
            }
            

And by using Binding adapter we can bind this validation to our XML

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
  * Second example of two way binding is checkbox , when user click on remember me a Boolean observalbe will be updated accordingly on VM and you can use this boolean value to do some logic.
    
