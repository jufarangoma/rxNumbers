package com.example.rxnumbersexample.presentation.view.main

import com.example.rxnumbersexample.data.models.TransferId

sealed class MainState {
    class Success(val number: Int): MainState()
}
