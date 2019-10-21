package com.hemdan.mvipopularactors.di.module

import android.content.Context
import com.hemdan.mvipopularactors.BuildConfig
import com.hemdan.mvipopularactors.BuildConfig.BASE_URL
import com.hemdan.mvipopularactors.data.remote.api.PopularActorsListApi
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Named


/**
 * Created by Mohammed Hemdan on 2019-10-21.
 * Email : mohammed.hemdan.faraj@gmail.com
 * Github : https://github.com/mhemdan
 */
@Module
class NetworkModule {

    private val TIMEOUT_IN_MS = 30000L

    @Provides
    @Named("apiKeyInterceptor")
    internal fun provideApiKeyInterceptor() = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            var request = chain.request()
            val url = request.url.newBuilder().addQueryParameter("api_key", BuildConfig.API_KEY).build()
            request = request.newBuilder().url(url).build()
            return chain.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        @Named("apiKeyInterceptor") apiKeyInterceptor: Interceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
            .addInterceptor(apiKeyInterceptor)
            .cache(cache)
            .build()
    }

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {
        val cacheSize: Long = 5 * 1024 * 1024 // 5 MB
        return Cache(context.cacheDir, cacheSize)
    }


    @Provides
    @Singleton
    fun provideRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        rxAdapter: RxJava2CallAdapterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(rxAdapter)
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Reusable
    internal fun provideActorsListApi(retrofit: Retrofit): PopularActorsListApi =
        retrofit.create(PopularActorsListApi::class.java)


}