rootProject.name = "kotlin-graphql-sample"

pluginManagement {
    resolutionStrategy {
        val kotlinVersion: String by settings
        val springBootVersion: String by settings
        eachPlugin {
            when (requested.id.id) {
                "org.jetbrains.kotlin.jvm" -> useModule("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
                "org.jetbrains.kotlin.plugin.spring" -> useModule("org.jetbrains.kotlin:kotlin-allopen:$kotlinVersion")
                "org.jetbrains.kotlin.plugin.jpa" -> useModule("org.jetbrains.kotlin:kotlin-noarg:$kotlinVersion")
                "io.spring.dependency-management", "org.springframework.boot" -> useModule("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
                "org.flywaydb.flyway" -> useModule("gradle.plugin.com.boxfuse.client:gradle-plugin-publishing:5.2.1")
            }
        }
    }

    repositories {
        mavenCentral()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}
