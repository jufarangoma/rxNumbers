package com.example.rxnumbersexample.presentation.view.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rxnumbersexample.R
import com.example.rxnumbersexample.data.models.TransferId
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import kotlinx.android.synthetic.main.acitivty_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity: AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    var listNumbers= arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivty_main)
        viewModel.operatorMath()
        initObservers()
        layoutManager()
    }

    private fun layoutManager() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        rcvRandomNumbers.layoutManager = layoutManager
    }

    private fun initObservers() {
        viewModel.getMainState().observe(this, Observer { mainState ->
            when(mainState){
                is MainState.Success -> {
                    listNumbers.add(mainState.number)
                    setAdapter()
                }
            }
        })
    }

    private fun setAdapter() {
        val adapter = MainAdapter()
        rcvRandomNumbers.adapter = adapter
        adapter.transferList = listNumbers
    }


    fun test(): Single<Long> {
        return Observable.just("2,46,890,086").count()
    }
}