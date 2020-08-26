object Dependencies {

  object BuildPlugins {
    const val android = "com.android.tools.build:gradle:${Version.Google.androidGradlePlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
  }

  object Libraries {

    object Kotlin {
      const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
    }

    object Google {
      const val material = "com.google.android.material:material:${Version.Google.material}"
    }

    object AndroidX {
      const val appcompat = "androidx.appcompat:appcompat:${Version.AndroidX.appcompat}"
      const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.AndroidX.constraintlayout}"
    }
  }
}