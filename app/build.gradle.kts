plugins {
  id("com.android.application")
  id("com.squareup.anvil") version (Version.anvil)
  kotlin("android")
  kotlin("plugin.serialization") version (Version.Kotlin.stdlib)
  kotlin("kapt")
}

android {
  compileSdkVersion(Config.compileSdkVersion)
  buildToolsVersion(Config.buildToolsVersion)

  defaultConfig {
    applicationId = Config.applicationId
    minSdkVersion(Config.minSdkVersion)
    targetSdkVersion(Config.targetSdkVersion)
    versionCode = Config.versionCode
    versionName = Config.versionName

    buildFeatures.viewBinding = true
  }
  buildTypes {
    getByName("debug") {
      isMinifyEnabled = false
    }
    getByName("release") {
      isMinifyEnabled = true
      isZipAlignEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  lintOptions {
    disable(
        "UnsafeExperimentalUsageError",
        "UnsafeExperimentalUsageError"
    )
  }
  sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
  }
}

dependencies {
  implementation(Dependencies.Libraries.Kotlin.stdlib)
  implementation(Dependencies.Libraries.Kotlin.serialization)

  implementation(Dependencies.Libraries.Google.material)

  implementation(Dependencies.Libraries.AndroidX.appcompat)
  implementation(Dependencies.Libraries.AndroidX.constraintlayout)

  implementation(Dependencies.Libraries.Dagger.core)
  kapt(Dependencies.Libraries.Dagger.compiler)

  implementation(Dependencies.Libraries.ReactiveX.rxjava)
  implementation(Dependencies.Libraries.ReactiveX.rxkotlin)
  implementation(Dependencies.Libraries.ReactiveX.rxandroid)

  implementation(Dependencies.Libraries.OkHttp.logging)

  implementation(Dependencies.Libraries.Retrofit.core)
  implementation(Dependencies.Libraries.Retrofit.converter)
  implementation(Dependencies.Libraries.Retrofit.adapter)

  implementation(Dependencies.Libraries.Coil.core)
}
