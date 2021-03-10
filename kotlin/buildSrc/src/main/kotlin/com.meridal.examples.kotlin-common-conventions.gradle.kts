object Kotlin {
    const val bom = "org.jetbrains.kotlin:kotlin-bom"
    const val reflect = "org.jetbrains.kotlin:kotlin-reflect"
    const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
}

object JUnit {
    const val core = "junit:junit:4.13.2"
    const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:5.6.2"
    const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine"
    const val vintageEngine = "org.junit.vintage:junit-vintage-engine"
}

object Spec2 {
    const val version = "2.0.15"
    const val dslJvm = "org.spekframework.spek2:spek-dsl-jvm:$version"
    const val junit5Runner = "org.spekframework.spek2:spek-runner-junit5:$version"
}

plugins {
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    jcenter()
}

dependencies {
    constraints {
        implementation("org.apache.commons:commons-text:1.9")
        implementation(Kotlin.stdlib)
    }
    implementation(platform(Kotlin.bom))
    implementation(Kotlin.stdlib)
    testImplementation(JUnit.jupiterApi)
    testImplementation(Spec2.dslJvm)
    testRuntimeOnly(JUnit.jupiterEngine)
    testRuntimeOnly(JUnit.vintageEngine)
    testRuntimeOnly(Spec2.junit5Runner)
    testRuntimeOnly(Kotlin.reflect)
    testCompileOnly(JUnit.core)
}

tasks.test {
    useJUnitPlatform() {
        includeEngines("junit-vintage")
        includeEngines("spek2")
    }
}