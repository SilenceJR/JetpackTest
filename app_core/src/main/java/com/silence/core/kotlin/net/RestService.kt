package com.silence.core.kotlin.net

import java.util.WeakHashMap

import io.reactivex.Observable
import okhttp3.MultipartBody
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.QueryMap
import retrofit2.http.Streaming
import retrofit2.http.Url

/**
 * @author Silence
 */
interface RestService {

    @GET
    operator fun get(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Observable<String>

    @FormUrlEncoded
    @POST
    fun post(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Observable<String>

    @FormUrlEncoded
    @PUT
    fun put(@Url url: String, @FieldMap params: WeakHashMap<String, Any>): Observable<String>

    @Streaming
    @GET
    fun download(@Url url: String, @QueryMap params: WeakHashMap<String, Any>): Observable<String>

    @Multipart
    @POST
    fun upload(@Url url: String, @Part file: MultipartBody.Part): Observable<String>

}
