plugins {
    id("com.android.library")
    id("kotlin-android")
}

ext {
    set("PUBLISH_GROUP_ID", Configuration.artifactGroup)
    set("PUBLISH_VERSION", Configuration.versionName)
    set("PUBLISH_ARTIFACT_ID", Configuration.artifactSeesaw)
}

apply {
    from("${rootProject.projectDir}/scripts/publish-mavencentral.gradle")
}

android {
    compileSdkVersion(Configuration.compileSdkVersion)

    defaultConfig {
        minSdkVersion(Configuration.minSdkVersion)
        targetSdkVersion(Configuration.targetSdkVersion)
        versionName = Configuration.versionName
    }

    buildFeatures {
        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Configuration.jvmTarget
    }
}

dependencies {
    implementation(Dependencies.kotlinStdLib)
    implementation(Dependencies.androidxAppCompat)
    implementation(Dependencies.androidxLifecycleCommonJava8)
    implementation(Dependencies.androidxLifecycleLiveDataKTX)
    implementation(Dependencies.timber)
    implementation(Dependencies.gson)
}