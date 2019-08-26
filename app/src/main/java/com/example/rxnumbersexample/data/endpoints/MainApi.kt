package com.example.rxnumbersexample.data.endpoints

import com.example.rxnumbersexample.data.models.ArrayTransfersId
import io.reactivex.Observable
import retrofit2.http.GET

interface MainApi {

    @GET("numbers")
    fun getNumbers(): Observable<ArrayTransfersId>
}