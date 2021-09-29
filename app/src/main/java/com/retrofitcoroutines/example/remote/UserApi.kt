package com.retrofitcoroutines.example.remote

import com.retrofitcoroutines.example.model.UserList
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET("users")
    suspend fun getUsers(): Response<UserList>

}