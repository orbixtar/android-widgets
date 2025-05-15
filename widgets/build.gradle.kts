plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
    id("signing")
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

/*afterEvaluate {
    publishing{
        publications{
            create<MavenPublication>("release"){
                from(components["release"])
                groupId = "com.cloudonesol"
                artifactId = "widgets"
                version = "1.0.1"

                pom {
                    name.set("Orbixtar Widgets")
                    description.set("A collection of custom Android UI widgets.")
                    url.set("https://github.com/orbixtar/android-widgets") // update this
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
                        connection.set("scm:git:https://github.com/orbixtar/android-widgets.git")
                        developerConnection.set("scm:git:ssh://git@github.com:orbixtar/android-widgets.git")
                        url.set("https://github.com/orbixtar/android-widgets")
                    }
                }
            }
        }

        repositories {
            maven {
                name = "MavenCenteral"
                url = uri("https://ossrh-staging-api.central.sonatype.com/service/local/staging/deploy/maven2/")
                credentials {
                    username = project.findProperty("ossrhUsername") as String? ?: ""
                    password = project.findProperty("ossrhPassword") as String? ?: ""
                }
            }
        }
    }

    signing {
        useGpgCmd()
        sign(publishing.publications["release"])
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