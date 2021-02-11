import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    kotlin("jvm") version "1.4.10"
    application
}
group = "me.kimreik"

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
dependencies {
//    implementation("org.junit.jupiter:junit-jupiter:5.4.2")

    testImplementation(kotlin("test-junit5"))
    testImplementation("io.kotest:kotest-assertions-jvm:4.0.7")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.10")


}
tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
application {
    mainClassName = "MainKt"
}