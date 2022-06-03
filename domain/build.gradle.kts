plugins {
    id("org.jetbrains.kotlin.jvm")
}

dependencies {
    api("com.google.dagger:dagger:2.42")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    api("com.google.code.gson:gson:2.8.9")
    api("com.squareup.retrofit2:converter-gson:2.3.0")
    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.okhttp3:okhttp:5.0.0-alpha.3")
    api("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.3")
}