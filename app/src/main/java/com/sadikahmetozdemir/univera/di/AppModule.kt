package com.sadikahmetozdemir.univera.di

import android.content.Context
import com.sadikahmetozdemir.univera.core.repository.DefaultRepository
import com.sadikahmetozdemir.univera.core.shared.service.AlbumAPI
import com.sadikahmetozdemir.univera.core.utils.NetworkInterceptor
import com.sadikahmetozdemir.univera.utils.Constants
import com.sadikahmetozdemir.univera.utils.DataHelperManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideAlbumService(retrofitClient: Retrofit) = retrofitClient.create(AlbumAPI::class.java)

    @Provides
    @Singleton
    fun provideDefaultRepository(
        albumAPI: AlbumAPI
    ): DefaultRepository {
        return DefaultRepository(albumAPI)
    }
    @Singleton
    @Provides
    fun provideDataManager(@ApplicationContext context: Context): DataHelperManager {
        return DataHelperManager(context)
    }

    @Provides
    @Singleton
    fun provideInterceptor(networkInterceptor: NetworkInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(networkInterceptor)
            .build()
    }
}
