plugins {
    kotlin("jvm") version "1.9.10"
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    wrapper {
        gradleVersion = "8.3"
    }
}

tasks.test {
    useJUnitPlatform()
}
