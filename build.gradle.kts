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

repositories {
    mavenCentral()
    jcenter()
    maven(url = "http://repo.spring.io/libs-milestone")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    compile("org.springframework.boot:spring-boot-starter")

    val graphqlSpringVersion = "5.0.4"
    compile("com.graphql-java-kickstart:graphql-spring-boot-starter:$graphqlSpringVersion")
    compile("com.graphql-java-kickstart:graphiql-spring-boot-starter:$graphqlSpringVersion")
    compile("com.graphql-java-kickstart:graphql-java-tools:5.3.3")

    // データベース
    compile("org.springframework.boot:spring-boot-starter-jdbc")
    compile("org.flywaydb:flyway-core")
    runtime("org.postgresql:postgresql")

    // ログ
    val springCloudGcpVersion = "1.1.0.RC2"
    compile("org.springframework.cloud:spring-cloud-gcp-starter-logging:$springCloudGcpVersion")
    compile("org.springframework.cloud:spring-cloud-gcp-starter-trace:$springCloudGcpVersion") {
        // remove this after 1.1.0.RELEASE
        exclude(group = "io.grpc")
    }
    compile("app.ubie:brave-kt:1.0.0")

    testCompile("org.springframework.boot:spring-boot-starter-test")
}
