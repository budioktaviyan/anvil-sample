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
  configurations.all {
    resolutionStrategy.eachDependency {
      if (requested.group == "org.jetbrains.kotlin") {
        useVersion(ver.kotlin.stdlib)
      }
    }
  }
}

tasks.register<Delete>("clean") {
  delete(rootProject.buildDir)
}
