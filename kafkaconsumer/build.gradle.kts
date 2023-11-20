plugins {
    java
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id ("com.github.davidmc24.gradle.plugin.avro") version "1.9.1"
}

group = "com.example.kafkaconsumer"
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

avro {
//    createSetters = true
    fieldVisibility = "PRIVATE"
    stringType = "String"
    outputCharacterEncoding = "UTF-8"

}
sourceSets {
    main {
        java {
            srcDirs("build/generated/main/avro") // Directory containing generated Java files
        }
    }
}

dependencies {
    implementation("io.confluent:kafka-avro-serializer:7.5.2")
//    implementation("io.confluent:kafka-avro-deserializer:7.5.2")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.kafka:spring-kafka")
    implementation("org.apache.avro:avro:1.11.1")
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
