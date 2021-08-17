package id.android.anvil.core.module

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.squareup.anvil.annotations.ContributesTo
import dagger.Module
import dagger.Provides
import id.android.anvil.BuildConfig
import id.android.anvil.core.qualifier.SingleIn
import id.android.anvil.core.scope.ApplicationScope
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import okhttp3.logging.HttpLoggingInterceptor.Level.NONE
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

@Module
@ContributesTo(ApplicationScope::class)
object NetworkModule {

  @Provides
  @SingleIn(ApplicationScope::class)
  fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor =
    HttpLoggingInterceptor().apply {
      level = when (BuildConfig.DEBUG) {
        true -> BODY
        false -> NONE
      }
    }

  @Provides
  @SingleIn(ApplicationScope::class)
  fun providesHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
    OkHttpClient.Builder().apply {
      retryOnConnectionFailure(true)
      addInterceptor(interceptor)
    }.build()

  @ExperimentalSerializationApi
  @Provides
  @SingleIn(ApplicationScope::class)
  fun providesHttpAdapter(client: OkHttpClient): Retrofit {
    val contentType = "application/json".toMediaType()
    val json = Json { ignoreUnknownKeys = true }

    return Retrofit.Builder().apply {
      client(client)
      baseUrl(BuildConfig.BASE_URL)
      addCallAdapterFactory(RxJava3CallAdapterFactory.create())
      addConverterFactory(json.asConverterFactory(contentType))
    }.build()
  }
}