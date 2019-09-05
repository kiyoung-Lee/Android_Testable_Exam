package com.example.testable

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter by lazy { MainPresenter(this) }
    lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataList = (1..10).toMutableList()

        adapter = ListAdapter(object : OnInteractionalListener{
            override fun onClickItem(data: Int, position: Int) {
                showToast("click $data")
                showSum(dataList.sum().toString())
            }

        }, dataList)
    }

    override fun showSum(text: String) {
        main_text.text = text
    }

    override fun showToast(msg: String){
       // show toast
    }
}
