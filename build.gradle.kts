plugins {
    kotlin("jvm") version "2.2.21"
    application
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass = "MainKt"
}

dependencies {
    implementation("ai.koog:koog-agents:0.5.2")
    implementation("org.slf4j:slf4j-simple:2.0.9")
}
