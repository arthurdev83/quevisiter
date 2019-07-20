package com.quevisiter.quevisiter.common.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*
import kotlin.TODO as TODO1
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import java.util.*


class RetrofitService() {

    val retrofit by lazy { buildRetrofit() }

    private fun buildRetrofit(): Retrofit {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        return Retrofit.Builder()
            .client(getUnsafeOkHttpClient())
            .baseUrl("http://api.quevisiter.fr")
            .addConverterFactory(GsonConverterFactory.create(gson))

            .build()
    }


    fun getUnsafeOkHttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(interceptor)
            .followRedirects(true)
            .followSslRedirects(true)
            .addInterceptor { chain ->
                val newRequest = chain.request().newBuilder()
                    .addHeader("JWT", "NOTOKEN")
                    .build()
                chain.proceed(newRequest)
            }
        return builder.build()
    }


}