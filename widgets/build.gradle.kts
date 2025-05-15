plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
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

/*publishing{
    publications{
        create<MavenPublication>("release"){
            from(components["release"])
            groupId = "com.orbixtartechnologies.widgets"
            artifactId = "core"  // can be `loadingbutton`, `core`, etc.
            version = "1.0.0"

            pom {
                name.set("Orbixtar Widgets")
                description.set("A collection of custom Android UI widgets.")
                url.set("https://github.com/yourgithub/widgets") // update this
                licenses {
                    license {
                        name.set("The MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("orbixtartechnologies")
                        name.set("Orbixtar Technologies")
                        email.set("orbixtartechnologies@gmail.com")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/yourgithub/widgets.git")
                    developerConnection.set("scm:git:ssh://git@github.com:yourgithub/widgets.git")
                    url.set("https://github.com/yourgithub/widgets")
                }
            }
        }
    }
}

repositories {
    maven {
        name = "MavenCentral"
        url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
        credentials {
            username = project.findProperty("ossrhUsername") as String? ?: ""
            password = project.findProperty("ossrhPassword") as String? ?: ""
        }
    }
}*/

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}