buildscript {
    repositories {
        maven {
            url = uri("https://plugins.gradle.org/m2/")
        }
    }
    dependencies {
        classpath("gradle.plugin.com.github.spotbugs.snom:spotbugs-gradle-plugin:4.3.0")
    }
}


allprojects {
    repositories {
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    apply(plugin = "java")
    apply(plugin = "checkstyle")
    apply(plugin = "com.github.spotbugs")
    dependencies {
        "testImplementation"("org.assertj:assertj-core:3.11.1")
    }
}

subprojects {
    version = "1.0"
}
