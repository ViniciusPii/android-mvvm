package com.example.mvvm.repositories

import com.example.mvvm.rest.RetrofitService

class MainRepository(
    private val retrofitService: RetrofitService
) {
    fun getAllLives() = retrofitService.getAllLives()
}