plugins {
    kotlin("jvm") version "1.7.0"
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    wrapper {
        gradleVersion = "7.5.1"
    }
}

tasks.test {
    useJUnitPlatform()
}
