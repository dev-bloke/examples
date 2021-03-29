import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm")
	kotlin("plugin.spring") version "1.4.30"
	kotlin("plugin.jpa") version "1.4.30"
	kotlin("plugin.allopen") version "1.3.61"
}

group = "com.meridal.examples"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.github.derjust:spring-data-dynamodb:5.1.0")
	implementation("com.amazonaws:aws-java-sdk-dynamodb:1.11.986")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation("org.apache.commons:commons-lang3:3.11")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("com.ninja-squad:springmockk:1.1.3")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

allOpen {
	annotation("com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable")
	annotation("com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}