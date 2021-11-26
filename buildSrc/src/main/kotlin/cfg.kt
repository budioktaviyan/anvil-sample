@file:Suppress("ClassName", "SpellCheckingInspection")

object cfg {

  object android {
    const val compileSdkVersion = 30
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 28
    const val targetSdkVersion = 30
  }

  object app {
    const val applicationId = "id.android.anvil"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val key = "\"f920accbb779fcb3ab3bbec9a8b40bd0\""
    const val baseUrl = "\"https://api.themoviedb.org\""
    const val imageUrl = "\"https://image.tmdb.org/t/p/original\""
  }
}