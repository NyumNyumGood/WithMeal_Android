package org.android.wantedhackathon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.android.wantedhackathon.network.RetrofitInterface
import org.android.wantedhackathon.preference.UserPreferenceManager
import org.android.wantedhackathon.qualifier.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideNetworkInterceptor(userPreferenceManager: UserPreferenceManager) : Interceptor {
        return Interceptor { chain ->
            val request = chain.request().newBuilder()
            val accessToken = "Bearer " + userPreferenceManager.fetchUserAccessToken()
            request.addHeader(TOKEN_TYPE, accessToken)
            chain.proceed(request.build())
        }
    }

    @Provides
    @Singleton
    @UnAuthOkHttp
    fun provideAuthOkHttpClientBuilder(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @AuthOkHttp
    fun provideOkHttpClientBuilder(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @UnAuthRetrofit
    fun provideAuthRetrofit(@UnAuthOkHttp okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://3.36.248.213:8080")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    @AuthRetrofit
    fun provideRetrofit(@AuthOkHttp okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl("http://3.36.248.213:8080")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()

    @Provides
    @Singleton
    @UnAuthRetrofitService
    fun provideRetrofitInterface(@UnAuthRetrofit retrofit: Retrofit) : RetrofitInterface =
        retrofit.create(RetrofitInterface::class.java)

    private const val TOKEN_TYPE = "Authorization"
}