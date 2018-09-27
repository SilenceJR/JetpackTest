package com.silence.core.kotlin.net

import com.silence.core.kotlin.app.ConfigType
import com.silence.core.kotlin.app.Core
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit

object RestCreator {

    private class ParamsHolder {
        companion object {
            val PARAMS = WeakHashMap<String, Any>()
        }
    }

    private class OkHttpHolder {
        companion object {
            private val TIME_OUT: Long = 60
            val OK_HTTP_CLIENT = OkHttpClient.Builder()
                    .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
        }
    }

    private class RetrofitHolder {
        companion object {
            private val BASE_URL: String = Core.getConfigurations().get(ConfigType.APP_HOST.name) as String
            val RETROFIT_CLIENT = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(OkHttpHolder.OK_HTTP_CLIENT)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
    }

    private class RestServiceHolder {
        companion object {
            val REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create(RestService::class.java)
        }
    }

    fun getRestService() = RestServiceHolder.REST_SERVICE

    fun getParams() = ParamsHolder.PARAMS


}