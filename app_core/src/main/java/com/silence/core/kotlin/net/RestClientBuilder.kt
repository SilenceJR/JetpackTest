package com.silence.core.kotlin.net

import java.util.*

class RestClientBuilder {

    var mUrl = null
    val mParams = RestCreator.getParams()

    fun addParam(key : String , value: Any) : RestClientBuilder {
        mParams.put(key, value)
        return this
    }








}