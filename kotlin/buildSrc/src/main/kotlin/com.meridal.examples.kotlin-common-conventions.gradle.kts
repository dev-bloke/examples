plugins {
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    jcenter()
}

dependencies {
    constraints {
        implementation("org.apache.commons:commons-text:1.9")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    }
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("org.junit.vintage:junit-vintage-engine")
    testCompileOnly("junit:junit:4.13.2")
}

tasks.test {
    useJUnitPlatform() {
        includeEngines("junit-vintage")
    }
}