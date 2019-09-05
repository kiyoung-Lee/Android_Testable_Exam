package com.example.testable.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.testable.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private val presenter by lazy { LoginPresenter(this, DBHelperImpl()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_button.setOnClickListener { presenter.joinNewMember(getLoginData()) }
    }

    private fun getLoginData(): LoginData {
        val loginData = LoginData()
        loginData.name = name.text.toString()
        loginData.nickName = nickname.text.toString()
        loginData.birthday = birthday.text.toString()
        loginData.homepage = homepage.text.toString()
        loginData.phoneNumber = phone.text.toString()

        return loginData
    }

    override fun showIntroActivity() {
        // startActivity()
    }

    override fun showToast(msg: String) {
        // show Toast
    }
}
