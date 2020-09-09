package com.etienne.vincent.sportdb.presentation

import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {
    abstract val presenter: BasePresenter
    // Must be overridden by all Activities
    abstract fun initUI()

    override fun onStart() {
        super.onStart()
        initUI()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onCleared()
    }
}