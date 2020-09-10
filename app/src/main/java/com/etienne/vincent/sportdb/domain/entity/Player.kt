package com.etienne.vincent.sportdb.domain.entity


data class Player(
    val id : Int,
    val name : String,
    val position: String,
    val dateBorn: String,
    val signingAmount: String,
    val imageUrl: String
)