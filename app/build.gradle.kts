plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs")
    id("com.akaita.android.easylauncher")
}

android {
    compileSdk = 34
    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        val scheme = "caka"

        buildConfigField("String", "SCHEME", "\"$scheme\"")

        addManifestPlaceholders(mapOf(
            "APPLICATION_ID" to applicationId!!,
            "SCHEME" to scheme
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
    }   
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(project(":backend"))

    // Kotlin
    implementation(kotlin("stdlib-jdk8", KotlinCompilerVersion.VERSION))

    // Androidx
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Navigation
    implementation("androidx.navigation:navigation-fragment-ktx:2.3.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.3.3")

    // ReactiveX
    implementation("com.uber.autodispose2:autodispose:2.0.0")
    implementation("com.uber.autodispose2:autodispose-android:2.0.0")
    implementation("com.uber.autodispose2:autodispose-androidx-lifecycle:2.0.0")

    // Dependency injection
    implementation("com.google.dagger:dagger:2.31.2")
    kapt("com.google.dagger:dagger-compiler:2.31.2")

    // Others
    implementation("com.jakewharton.timber:timber:4.7.1")
    implementation("com.evernote:android-state:1.4.1")
    kapt("com.evernote:android-state-processor:1.4.1")

    // For debugging
    debugImplementation("com.facebook.flipper:flipper:0.23.2")
    debugImplementation("com.facebook.soloader:soloader:0.10.1")
    releaseImplementation("com.facebook.flipper:flipper-noop:0.23.2")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-core:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-attr:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-build-config:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-crash:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-disk:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-geiger-counter:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-measurement:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-phoenix:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-recorder:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-shared-preferences:0.9.31")
    debugImplementation("com.willowtreeapps.hyperion:hyperion-timber:0.9.31")
    releaseImplementation("com.willowtreeapps.hyperion:hyperion-core-no-op:0.9.31")
}

tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class.java).all {
    kotlinOptions.jvmTarget = "1.8"
}
