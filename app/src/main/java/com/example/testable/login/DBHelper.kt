package com.example.testable.login

interface DBHelper {

    fun updateNewMember(loginData: LoginData): Boolean
}