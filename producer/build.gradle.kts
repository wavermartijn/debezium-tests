plugins {
    java
//    id("com.nedap.nefeli.application-module")
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
}

group = "com.example.producer"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
    //confluent
    maven {
        url = uri("https://packages.confluent.io/maven/")
    }
}

dependencies {
//    api(project(":kafkaconsumer"))
    implementation("io.confluent:kafka-avro-serializer:7.5.2")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.kafka:spring-kafka")
//    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
//    implementation("org.springframework.cloud:spring-cloud-stream-schema")
    implementation("org.apache.avro:avro:1.11.1")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootBuildImage {
    builder.set("paketobuildpacks/builder-jammy-base:latest")
}
