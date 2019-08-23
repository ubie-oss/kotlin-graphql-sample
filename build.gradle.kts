import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot")
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.spring")
    id("org.jetbrains.kotlin.plugin.jpa")
    id("io.spring.dependency-management")
    id("jacoco")
    id("org.jlleitschuh.gradle.ktlint")
    id("org.flywaydb.flyway")
}

version = "1.0.0"

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

val test by tasks.getting(Test::class) {
    useJUnitPlatform()
    maxHeapSize = "3g"
}

jacoco {
    toolVersion = "0.8.2"
}

val jacocoTestReport by tasks.getting(JacocoReport::class) {
    reports {
        xml.isEnabled = true
        html.isEnabled = true
    }
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springframework.boot:spring-boot-starter")

    val graphqlSpringVersion: String by project
    implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:$graphqlSpringVersion")
    implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:$graphqlSpringVersion")
    implementation("com.graphql-java-kickstart:altair-spring-boot-starter:$graphqlSpringVersion")
    implementation("com.graphql-java-kickstart:graphql-java-tools:5.5.1")

    // データベース
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    implementation("org.flywaydb:flyway-core")
    runtime("org.postgresql:postgresql")

    // test
    val junitVersion: String by project
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntime("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.assertj:assertj-core:3.11.1")
    testImplementation("io.mockk:mockk:1.8.9.kotlin13")
    testImplementation("com.ninja-squad:DbSetup-kotlin:2.1.0")
}