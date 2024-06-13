plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

android {
    namespace = "com.simpleseries.businesscalculator"
    compileSdk = 34

    defaultConfig {
        minSdk = 29

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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
}

dependencies {

    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.material3:material3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.2")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {// could be bar or release
                groupId = "com.github.fredywise.simpleseries"
                artifactId = "business-calculator"
                version = "0.0.2"
////                if using bar // you can get this by running assemble on Gradle/BusinessCalculator/Tasks/build/assembleRelease
//                artifact("$buildDir/outputs/aar/${project.name}-release.aar")
//                if using release
                from(components["release"])
            }
        }

//        if using bar
        repositories {
            maven { url = uri("https://jitpack.io") }
//            //bellow are move to settings.gradle.kts
//            maven {
//                name = "GitHubPackages"
//                url = uri("https://maven.pkg.github.com/FredyWise/Simple-Calculator")
//                credentials {
//                    username = System.getenv("GITHUB_USERNAME")
//                    password = System.getenv("GITHUB_TOKEN")
//                }
//            }
        }
    }
}