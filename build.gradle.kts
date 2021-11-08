// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
        classpath(Gradle.GRADLE_DEPENDENCY)
        classpath(Plugins.DAGGER_HILT_GRADLE_PLUGIN)
        classpath(Plugins.NAVIGATION_PLUGIN)
        classpath(Plugins.CLASSPATH_GMS_GOOGLE_SERVICES)
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}