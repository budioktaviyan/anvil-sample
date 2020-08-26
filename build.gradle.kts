buildscript {
  repositories {
    google()
    jcenter()
  }
  dependencies {
    classpath(Dependencies.BuildPlugins.android)
    classpath(Dependencies.BuildPlugins.kotlin)
  }
}

allprojects {
  repositories {
    google()
    jcenter()
  }
}

tasks.register<Delete>("clean") {
  delete(rootProject.buildDir)
}
