plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)

    //agrego plugins para dagger hilt y kapt
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

    //agrego plugins para agregar argumentos en la navegacion
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.luckyapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.luckyapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            //cambio el nombre de la app en release
            resValue("string", "app_name", "Lucky App")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
        getByName("debug") {
            isDebuggable = true
            //cambio el nombre de la app en debug
            resValue("string", "app_name", "[DEBUG] - Lucky App")

            //tambien puedo crear valores que no existen en values/strings.xml
            //y se usa igual: @string/nuevo_valor en el manifest para accederlos
            resValue("string", "nuevo_valor", "debug nuevo valor")

            //TODO: crear base url para debug
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    //agrego dependencia para poder usar viewBinding
//    viewBinding {
//        enable = true
//    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    //navegacion
    val navVersion = "2.7.7"
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //dagger hilt
    val hiltVersion = "2.48"
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")

    //importo retrofit
    val retrofit = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}