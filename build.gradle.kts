import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.3.11"
}

group = "it.krzeminski"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform { }
}

dependencies {
    compile(kotlin("stdlib-jdk8"))

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.2.1")
    testImplementation("com.github.ajalt:clikt:2.3.0")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}