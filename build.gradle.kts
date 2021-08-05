buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(Dependencies.BuildPlugins.android)
    classpath(Dependencies.BuildPlugins.kotlin)
  }
}

allprojects {
  repositories {
    google()
    mavenCentral()
  }
}

tasks.register<Delete>("clean") {
  delete(rootProject.buildDir)
}
