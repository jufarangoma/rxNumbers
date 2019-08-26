package com.example.rxnumbersexample.data.models

import com.squareup.moshi.Json

class ArrayTransfersId{
    @field:Json(name = "transfers")
    var transfers: List<TransferId> = listOf()
}

class TransferId {
    @field:Json(name = "transfer_id")
    var transferId : Int=0
}
