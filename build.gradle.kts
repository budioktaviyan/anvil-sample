buildscript {
  repositories {
    google()
    mavenCentral()
  }
  dependencies {
    classpath(dep.build_plugins.android)
    classpath(dep.build_plugins.kotlin)
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
