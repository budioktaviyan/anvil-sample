plugins {
  id("com.android.application")
  kotlin("android")
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

  implementation(Dependencies.Libraries.Google.material)

  implementation(Dependencies.Libraries.AndroidX.appcompat)
  implementation(Dependencies.Libraries.AndroidX.constraintlayout)
}
