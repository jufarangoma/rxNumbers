package com.example.rxnumbersexample.presentation.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rxnumbersexample.data.models.TransferId
import com.example.rxnumbersexample.databinding.CardNumbersBinding

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    var transferList = listOf<Int>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemBinding = CardNumbersBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return MainViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return transferList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setNumber(transferList[position])
    }

    class MainViewHolder(var view: CardNumbersBinding): RecyclerView.ViewHolder(view.root){

        fun setNumber(transferId: Int) {
            view.apply{
                this.number = transferId
            }
        }
    }
}