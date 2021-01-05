object Dependencies {

  object BuildPlugins {
    const val android = "com.android.tools.build:gradle:${Version.Google.androidGradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.Kotlin.stdlib}"
  }

  object Libraries {

    object Kotlin {
      const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin.stdlib}"
      const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.Kotlin.serialization}"
    }

    object AndroidX {
      const val appcompat = "androidx.appcompat:appcompat:${Version.AndroidX.appcompat}"
      const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.AndroidX.constraintlayout}"
    }

    object Google {
      const val material = "com.google.android.material:material:${Version.Google.material}"
    }

    object Dagger {
      const val core = "com.google.dagger:dagger:${Version.dagger}"
      const val compiler = "com.google.dagger:dagger-compiler:${Version.dagger}"
    }

    object ReactiveX {
      const val rxjava = "io.reactivex.rxjava3:rxjava:${Version.ReactiveX.rxjava}"
      const val rxkotlin = "io.reactivex.rxjava3:rxkotlin:${Version.ReactiveX.rxkotlin}"
      const val rxandroid = "io.reactivex.rxjava3:rxandroid:${Version.ReactiveX.rxandroid}"
    }

    object OkHttp {
      const val logging = "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}"
    }

    object Retrofit {
      const val core = "com.squareup.retrofit2:retrofit:${Version.Retrofit.core}"
      const val converter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${Version.Retrofit.converter}"
      const val adapter = "com.squareup.retrofit2:adapter-rxjava3:${Version.Retrofit.core}"
    }

    object Coil {
      const val core = "io.coil-kt:coil:${Version.coil}"
    }
  }
}