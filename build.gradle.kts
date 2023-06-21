import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	val kotlinVersion = "1.7.20"
	id("org.springframework.boot") version "3.1.0"
	id("io.spring.dependency-management") version "1.1.0"
	id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
	kotlin("plugin.jpa") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion
	kotlin("jvm") version kotlinVersion
}

extra["springCloudVersion"] = "2022.0.3"

allOpen {
	annotation("jakarta.persistence.Entity")
}

noArg {
	annotation("jakarta.persistence.Entity")
}

group = "com.slyj.server"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	// swagger
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.1.0")

	// jackson-core
	implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")

	// jackson-module
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.2")

	// Spring Security
	implementation("org.springframework.boot:spring-boot-starter-security")

	// jwt
	implementation("io.jsonwebtoken:jjwt-api:0.11.2")
	implementation("io.jsonwebtoken:jjwt-impl:0.11.2")
	implementation("io.jsonwebtoken:jjwt-jackson:0.11.2")

	//feign
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
/*

	// spring-cloud-starter-loadbalancer
	implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer")
*/


	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
