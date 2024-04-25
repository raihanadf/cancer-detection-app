plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.dicoding.asclepius"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dicoding.asclepius"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
        mlModelBinding = true
        buildConfig = true
    }


    buildTypes {
        debug {
            buildConfigField(
                "String",
                "API_URL",
                "\"https://newsapi.org/\""
            )
            buildConfigField(
                "String",
                "API_KEY",
                "\"663941d135444ae8a9a492f1eeda3747\""
            )
        }
        release {
            buildConfigField(
                "String",
                "API_URL",
                "\"https://newsapi.org/\""
            )
            buildConfigField(
                "String", "API_KEY",
                "\"663941d135444ae8a9a492f1eeda3747\""
            )
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
    }

    dependencies {
        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.appcompat:appcompat:1.6.1")
        implementation("com.google.android.material:material:1.11.0")
        implementation("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation("androidx.activity:activity:1.8.0")
        testImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test.ext:junit:1.1.5")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

        // TODO: Tambahkan Library TensorFlow Lite
        implementation("org.tensorflow:tensorflow-lite-metadata:0.1.0")
        implementation("org.tensorflow:tensorflow-lite-task-vision:0.4.4")

        // [[ uCrop ]]
        implementation("com.github.yalantis:ucrop:2.2.8")

        // [[ moshi and retrofit ]]
        implementation("com.squareup.retrofit2:retrofit:2.11.0")
        implementation("com.squareup.moshi:moshi:1.15.1")
        implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
        implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
        implementation("io.coil-kt:coil:2.6.0")

        // [[ lifecycle ]]
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
        implementation("androidx.fragment:fragment-ktx:1.6.2")

        // [[ room ]]
        val room_version = "2.6.1"
        implementation("androidx.room:room-ktx:2.6.1")
        implementation("androidx.room:room-runtime:$room_version")
        kapt("androidx.room:room-compiler:$room_version")

    }
}