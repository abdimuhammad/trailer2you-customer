plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
}

android {
    namespace = "apps.trailer2you.network"
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    flavorDimensions += listOf("api")
    productFlavors {
        create("production") {
            dimension = "api"
            buildConfigField(
                "String",
                "BASE_URL",
                BuildConfigField.PROD_BASE_URL
            )
            buildConfigField(
                "String",
                "WEB_SOCKET_BASE_URL",
                BuildConfigField.PROD_WEB_SOCKET_BASE_URL
            )
            buildConfigField(
                "String",
                "STRIPE_API_KEY",
                BuildConfigField.PROD_STRIPE_API_KEY
            )
        }
        create("development") {
            dimension = "api"
            buildConfigField(
                "String",
                "BASE_URL",
                BuildConfigField.DEV_BASE_URL
            )
            buildConfigField(
                "String",
                "WEB_SOCKET_BASE_URL",
                BuildConfigField.DEV_WEB_SOCKET_BASE_URL
            )
            buildConfigField(
                "String",
                "STRIPE_API_KEY",
                BuildConfigField.DEV_STRIPE_API_KEY
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
    }
    hilt {
        enableAggregatingTask = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.dagger.hilt.android)
    implementation(project(mapOf("path" to ":core:common")))
    kapt(libs.dagger.hilt.android.compiler)
    implementation(libs.okhttp3.core)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.okhttp3.okhttp)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
}