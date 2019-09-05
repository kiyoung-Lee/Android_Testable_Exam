package com.example.testable.login

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.math.log

@RunWith(MockitoJUnitRunner::class)
class LoginPresenterTest {

    lateinit var presenter: LoginPresenter

    @Mock
    lateinit var loginView: LoginView

    @Mock
    lateinit var dbHelper: DBHelper

    @Before
    fun setUp() {
        presenter = LoginPresenter(loginView, dbHelper)
    }

    @Test
    fun testJoinNewMemberSuccess() {
        val loginData = LoginData()
        whenever(dbHelper.updateNewMember(loginData)).thenReturn(true)

        presenter.joinNewMember(loginData)

        verify(loginView).showIntroActivity()
    }

    @Test
    fun testJoinNewMemberFail() {
        val loginData = LoginData()
        whenever(dbHelper.updateNewMember(loginData)).thenReturn(false)

        presenter.joinNewMember(loginData)

        verify(loginView).showToast("Error")
    }
}