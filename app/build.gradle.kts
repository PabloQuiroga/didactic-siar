plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.detekt)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
    alias(libs.plugins.gms)
}

android {
    namespace = "com.siar.siardelivery"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.siar.siardelivery"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            isDebuggable = true
            buildConfigField("String", "JSON_PLACEHOLDER", "\"https://jsonplaceholder.typicode.com/\"")
            buildConfigField("String", "MOCK_USER", "\"https://randomuser.me/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
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
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.livedata)

    //compose
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material.icons)
    //navigation compose
    implementation(libs.androidx.navigation.compose)
    //constraints compose
    implementation(libs.constraintslayout.compose)

    //splashScreen
    implementation(libs.androidx.splashscreen)

    //hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    //Hilt navigation compose
    implementation(libs.hilt.navigation)

    //retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    //firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.analytics)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}