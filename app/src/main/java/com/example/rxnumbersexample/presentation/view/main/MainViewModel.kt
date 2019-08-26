package com.example.rxnumbersexample.presentation.view.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxnumbersexample.domain.useCases.MainUC
import io.reactivex.Observable
import io.reactivex.Observable.fromIterable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel( private val mainUC: MainUC,
                     private val mainState: MutableLiveData<MainState>):ViewModel(){

    private val disposeBag = CompositeDisposable()

    fun getMainState() = mainState

    fun operatorMath(){
        disposeBag.add(mainUC.getTransfers()
            .subscribeOn(Schedulers.io())
            .subscribe({
                mainState.postValue(MainState.Success(it.transferId))
            },{
                it
            })
        )
    }
}