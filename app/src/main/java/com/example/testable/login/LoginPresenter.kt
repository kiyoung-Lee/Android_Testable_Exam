package com.example.testable.login

class LoginPresenter(
    private val loginView: LoginView,
    private val dbHelper: DBHelper
) {

    fun joinNewMember(loginData: LoginData){
        if(dbHelper.updateNewMember(loginData)){
            loginView.showIntroActivity()
        }else{
            loginView.showToast("Error")
        }
    }
}