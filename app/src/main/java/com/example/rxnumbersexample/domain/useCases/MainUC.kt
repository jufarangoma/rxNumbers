package com.example.rxnumbersexample.domain.useCases

import com.example.rxnumbersexample.data.endpoints.MainApi
import com.example.rxnumbersexample.data.models.ArrayTransfersId
import com.example.rxnumbersexample.data.models.TransferId
import io.reactivex.Observable
import io.reactivex.functions.Function

class MainUC(var mainApi: MainApi) {

    fun getTransfers(): Observable<TransferId> {

        return mainApi.getNumbers().map { it-> it.transfers }
            .flatMap { Observable.fromIterable(it) }
            .filter{it.transferId>88}
    }
}