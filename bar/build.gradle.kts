plugins {
  alias(libs.plugins.androidLib)
  alias(libs.plugins.kotlinAndroid)
  alias(libs.plugins.mavenPublish)
}

android {
  namespace = "com.hsicen.bar"
  compileSdk = 33

  defaultConfig {
    minSdk = 21
    targetSdk = 33

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
}

dependencies {
  implementation(libs.androidx.appcompat)
}

val group = "com.hsicen"
val version = "1.0.2"

publishing {
  publications {
    register<MavenPublication>("release") {
      groupId = groupId
      artifactId = "bar"
      version = version

      afterEvaluate {
        from(components["release"])
      }
    }
  }
}
