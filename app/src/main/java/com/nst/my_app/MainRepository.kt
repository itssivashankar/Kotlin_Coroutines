package com.nst.my_app

class MainRepository constructor(private val retrofitService: RetrofitService) {
    suspend fun getAllMovies () = retrofitService.getAllMovies()
}