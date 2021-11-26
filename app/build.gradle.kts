plugins {
    id(Plugins.APPLICATION)
    id(Plugins.HILT_ANDROID_PLUGIN)
    id(Plugins.SAFE_ARGS)
    id(Plugins.PARCELIZE)
    id("kotlin-android")
    id("kotlin-kapt")
}


android {
    compileSdk = DefaultConfig.COMPILE_SDK

    defaultConfig {
        applicationId = DefaultConfig.APPLICATION_ID
        minSdk = DefaultConfig.MIN_SDK
        targetSdk = DefaultConfig.TARGET_SDK
        buildToolsVersion = DefaultConfig.BUILD_TOOLS

        versionCode = DefaultConfig.VERSION_CODE
        versionName = DefaultConfig.VERSION_NAME
        testInstrumentationRunner = Test.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    compileOptions {
        sourceCompatibility =  JavaVersion.VERSION_1_8
        targetCompatibility =  JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.FRAGMENT_KTX)
    implementation(AndroidX.ACTIVITY_KTX)
    implementation(Kotlin.KOTLIN_STDLIBS)
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.1")
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    implementation ("com.github.Muzafferus:ImageList-Lib:1.0.1")
    
    testImplementation(Test.JUNIT)
    androidTestImplementation(Test.AndroidTest.JUNIT_EXT)
    androidTestImplementation(Test.AndroidTest.ESPRESSO_CORE)

    //Hilt
    implementation(DaggerHilt.HILT_ANDROID)
    kapt(DaggerHilt.HILT_ANDROID_COMPILER)

    //Retrofit
    implementation(Square.RETROFIT)
    implementation(Square.CONVERTER_GSON)
    implementation(Square.ADAPTER_RXJAVA)
    implementation(Square.GSON)

    //Navigation
    implementation(AndroidX.Navigation.NAVIGATION_FRAGMENT_KTX)
    implementation(AndroidX.Navigation.NAVIAGATION_UI_KTX)

    //Lifecycle
    implementation(AndroidX.Lifecycle.VIEWMODEL)
    implementation(AndroidX.Lifecycle.LIVEDATA)

    //OkHttp Logging Interceptor
    implementation(Square.OKHTTP_LOGGING_INTERCEPTOR)

    // RxJava
    implementation(ReactiveX.RX_JAVA)
    implementation(ReactiveX.RX_ANDROID)

    //Coil
    implementation(Coil.COIL)

    //Annotations
    implementation(Annotations.SUPPORT_ANNOTATIONS)

    //Crypto
    implementation(AndroidX.Crypto.CRYPTO)

    //Google Play Service
    implementation(Google.PLAY_SERVICES_LOCATION)

    //Naver Map
    implementation(NaverMap.NAVER_MAP) { exclude(group = "com.android.support") }

    //FlexBox
    implementation(Google.FLEX_BOX)


}