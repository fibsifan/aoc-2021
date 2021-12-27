plugins {
    kotlin("jvm") version "1.6.0"
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    wrapper {
        gradleVersion = "7.3"
    }
}

tasks.test {
    useJUnitPlatform()
}
