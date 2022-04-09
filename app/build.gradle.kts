plugins {
  id("com.android.application")
  id("com.squareup.anvil") version (ver.anvil)
  kotlin("android")
  kotlin("kapt")
  kotlin("plugin.serialization") version (ver.kotlin.stdlib)
}

android {
  compileSdk = cfg.android.compileSdk
  buildToolsVersion = cfg.android.buildToolsVersion

  defaultConfig {
    minSdk = cfg.android.minSdk
    targetSdk = cfg.android.targetSdk

    applicationId = cfg.app.applicationId
    versionCode = cfg.app.versionCode
    versionName = cfg.app.versionName

    buildFeatures.viewBinding = true

    buildConfigField("String", "API_KEY", cfg.app.key)
    buildConfigField("String", "BASE_URL", cfg.app.baseUrl)
    buildConfigField("String", "IMAGE_URL", cfg.app.imageUrl)
  }
  buildTypes {
    getByName("debug") {
      isMinifyEnabled = false
    }
    getByName("release") {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  sourceSets {
    getByName("main").java.srcDirs("src/main/kotlin")
  }
  compileOptions {
    sourceCompatibility(JavaVersion.VERSION_11)
    targetCompatibility(JavaVersion.VERSION_11)
  }
  kotlinOptions {
    jvmTarget = JavaVersion.VERSION_11.toString()
  }
}

dependencies {
  implementation(dep.libs.kotlin.stdlib)
  implementation(dep.libs.kotlin.serialization)

  implementation(dep.libs.google.material)

  implementation(dep.libs.androidx.appcompat)
  implementation(dep.libs.androidx.constraintlayout)
  implementation(dep.libs.androidx.lifecycle)

  implementation(dep.libs.dagger.core)
  kapt(dep.libs.dagger.compiler)

  implementation(dep.libs.reactivex.rxjava)
  implementation(dep.libs.reactivex.rxkotlin)
  implementation(dep.libs.reactivex.rxandroid)

  implementation(dep.libs.okhttp.logging)

  implementation(dep.libs.retrofit.core)
  implementation(dep.libs.retrofit.converter)
  implementation(dep.libs.retrofit.adapter)

  implementation(dep.libs.coil.core)
}
