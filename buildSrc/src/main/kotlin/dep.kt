@file:Suppress("ClassName", "SpellCheckingInspection")

object dep {

  object build_plugins {
    const val android = "com.android.tools.build:gradle:${ver.google.agp}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${ver.kotlin.stdlib}"
  }

  object libs {

    object kotlin {
      const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${ver.kotlin.stdlib}"
      const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${ver.kotlin.serialization}"
    }

    object androidx {
      const val appcompat = "androidx.appcompat:appcompat:${ver.androidx.appcompat}"
      const val constraintlayout = "androidx.constraintlayout:constraintlayout:${ver.androidx.constraintlayout}"
      const val lifecycle = "androidx.lifecycle:lifecycle-extensions:${ver.androidx.lifecycle}"
    }

    object google {
      const val material = "com.google.android.material:material:${ver.google.material}"
    }

    object dagger {
      const val core = "com.google.dagger:dagger:${ver.dagger}"
      const val compiler = "com.google.dagger:dagger-compiler:${ver.dagger}"
    }

    object reactivex {
      const val rxjava = "io.reactivex.rxjava3:rxjava:${ver.reactivex.rxjava}"
      const val rxkotlin = "io.reactivex.rxjava3:rxkotlin:${ver.reactivex.rxkotlin}"
      const val rxandroid = "io.reactivex.rxjava3:rxandroid:${ver.reactivex.rxandroid}"
    }

    object okhttp {
      const val logging = "com.squareup.okhttp3:logging-interceptor:${ver.okhttp}"
    }

    object retrofit {
      const val core = "com.squareup.retrofit2:retrofit:${ver.retrofit.core}"
      const val converter = "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:${ver.retrofit.converter}"
      const val adapter = "com.squareup.retrofit2:adapter-rxjava3:${ver.retrofit.core}"
    }

    object coil {
      const val core = "io.coil-kt:coil:${ver.coil}"
    }
  }
}