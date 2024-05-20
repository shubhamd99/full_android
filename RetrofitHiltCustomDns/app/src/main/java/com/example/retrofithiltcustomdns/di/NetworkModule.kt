package com.example.retrofithiltcustomdns.di

import com.example.retrofithiltcustomdns.api.PostAPI
import com.example.retrofithiltcustomdns.api.UserAPI
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.dnsoverhttps.DnsOverHttps
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.net.InetAddress
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    private val appCache = Cache(File("cacheDir", "okhttpcache"), 10 * 1024 * 1024)
    private val bootstrapClient = OkHttpClient.Builder().cache(appCache).build()

    private val dns = DnsOverHttps.Builder().client(bootstrapClient)
        .url("https://dns.google/dns-query".toHttpUrl())
        .bootstrapDnsHosts(
            InetAddress.getByName("8.8.4.4"), // Google Dns
            InetAddress.getByName("1.1.1.1"), // Cloudflare
            InetAddress.getByName("8.8.8.8") // Google Backup Dns
        )
        .build()

    private val client = bootstrapClient.newBuilder()
        .readTimeout(5000, java.util.concurrent.TimeUnit.MILLISECONDS)
        .writeTimeout(5000, java.util.concurrent.TimeUnit.MILLISECONDS)
        .connectTimeout(5000, java.util.concurrent.TimeUnit.MILLISECONDS)
        .retryOnConnectionFailure(true)
        .dns(dns)
        .build()

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun providePostAPI(retrofit: Retrofit): PostAPI {
        return retrofit.create(PostAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideUserAPI(retrofit: Retrofit): UserAPI {
        return retrofit.create(UserAPI::class.java)
    }
}