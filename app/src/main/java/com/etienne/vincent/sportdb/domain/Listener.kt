package com.etienne.vincent.sportdb.domain


interface Listener<T>{
    fun onSuccess(entity: T)
    fun onError()
}