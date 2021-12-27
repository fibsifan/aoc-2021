plugins {
    kotlin("jvm") version "1.6.10"
}

repositories {
    mavenCentral()
}
dependencies {
    testImplementation(kotlin("test"))
}

tasks {
    wrapper {
        gradleVersion = "7.3.3"
    }
}

tasks.test {
    useJUnitPlatform()
}
