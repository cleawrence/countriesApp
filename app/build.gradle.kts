plugins {
    id ("com.android.application")
    kotlin("android")
    id ("com.google.dagger.hilt.android")
    id ("kotlin-parcelize")
    id ("kotlin-kapt")
}

android {
    namespace = "com.appiwedia.apps.android.countriesapp"
    compileSdk =    33

    defaultConfig {
        applicationId = "com.appiwedia.apps.android.countriesapp"
        minSdk = 28
        targetSdk  = 33
        versionCode  = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.2"
    }
    packagingOptions {
        resources.excludes.add("META-INF/AL2.0")
        resources.excludes.add("META-INF/LGPL2.1")
        resources.excludes.add("**/attach_hotspot_windows.dll")
        resources.excludes.add("META-INF/licenses/ASM")
        resources.excludes.add("META-INF/*")
    }
}

dependencies {
    constraints {
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0") {
            because("kotlin-stdlib-jdk7 is now a part of kotlin-stdlib")
        }
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.8.0") {
            because("kotlin-stdlib-jdk8 is now a part of kotlin-stdlib")
        }
    }

    implementation ("androidx.core:core-ktx:1.9.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.5.1")
    implementation ("androidx.activity:activity-compose:1.6.1")
    implementation ("androidx.compose.ui:ui:1.3.3")
    implementation ("androidx.compose.ui:ui-tooling-preview:1.3.3")
    implementation ("androidx.compose.material:material:1.3.1")
    implementation ("androidx.core:core-ktx:+")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4:1.3.3")
    debugImplementation ("androidx.compose.ui:ui-tooling:1.3.3")
    debugImplementation ("androidx.compose.ui:ui-test-manifest:1.3.3")

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")

    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44.2")
    kapt("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
}


kapt {
    correctErrorTypes = true
}