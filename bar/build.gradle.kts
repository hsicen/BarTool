plugins {
  alias(libs.plugins.androidLib)
  alias(libs.plugins.kotlinAndroid)
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
