package com.example.testable

class MainPresenter(
    private val view: MainView
) {

    fun onClickItem(data: Int) {
        view.showToast("click $data")
        view.showSum("test")
    }
}