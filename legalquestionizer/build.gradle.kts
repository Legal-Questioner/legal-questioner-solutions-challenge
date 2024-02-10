plugins {
  java
  id("org.springframework.boot") version "3.2.2"
  id("io.spring.dependency-management") version "1.1.4"
}

group = "io.shaded"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

  implementation(platform("org.jdbi:jdbi3-bom:3.44.0"))
  implementation("org.jdbi:jdbi3-spring5")
  implementation("org.jdbi:jdbi3-sqlobject")
  implementation("org.jdbi:jdbi3-postgres")
  implementation("org.postgresql:postgresql:42.7.1")
  implementation("com.zaxxer:HikariCP:5.1.0")

  implementation("com.google.cloud:google-cloud-vertexai:0.1.0")
  implementation("io.github.cdimascio:dotenv-java:3.0.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
