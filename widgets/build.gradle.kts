plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
    id("signing")
    id("org.jreleaser") version "1.8.0"
}

android {
    namespace = "com.orbixtartechnologies.widgets"
    compileSdk = 35

    defaultConfig {
        minSdk = 21

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

publishing {
    publications {
        create<MavenPublication>("release") {
            afterEvaluate {
                from(components["release"]) // or components["default"] if release not found
            }

            groupId = "com.cloudonesol"
            artifactId = "widgets"
            version = "1.0.2"

            pom {
                name.set("OrbixTar Widgets")
                description.set("A professional set of custom Android UI widgets by OrbixTar Technologies.")
                url.set("https://github.com/orbixtar/android-widgets") // Replace with your repo

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("orbixtartechnologies")
                        name.set("OrbixTar Technologies")
                        email.set("orbixtartechnologies@gmail.com") // Replace with your email
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/OrbixTar/android-widgets.git")
                    developerConnection.set("scm:git:ssh://github.com/OrbixTar/android-widgets.git")
                    url.set("https://github.com/OrbixTar/android-widgets")
                }
            }
        }
    }

    repositories {
        // Required for local testing
        maven {
            name = "LocalTest"
            url = uri("$buildDir/repo")
        }
    }
}

signing {
    sign(publishing.publications["release"])
}