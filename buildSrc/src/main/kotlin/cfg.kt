@file:Suppress("ClassName", "SpellCheckingInspection")

object cfg {

  object android {
    const val compileSdk = 31
    const val buildToolsVersion = "31.0.0"
    const val minSdk = 29
    const val targetSdk = 31
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