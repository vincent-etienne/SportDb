package com.etienne.vincent.sportdb.presentation

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


abstract class BasePresenterImpl(
    private val dispatcher: CoroutineDispatcher
): CoroutineScope, BasePresenter {

    private var handler : CoroutineExceptionHandler = CoroutineExceptionHandler { _, throwable -> baseHandleException(throwable) }

    private var job: Job = SupervisorJob()

    override val coroutineContext: CoroutineContext
        get() = dispatcher + job + handler


    override fun onCleared() {
        job.cancelChildren()
    }

    private fun baseHandleException(throwable: Throwable) {
        handleException()
    }

    // Must be overridden by all Presenters
    abstract fun handleException()
}