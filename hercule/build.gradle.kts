plugins {
    application
}

repositories {
    // Use jcenter for resolving your dependencies.
    // You can declare any Maven/Ivy/file repository here.
    jcenter()
}

dependencies {
    implementation(project(":hercule-lib"))

    implementation("com.google.guava:guava:27.0.1-jre")

    testImplementation("junit:junit:4.12")
}

application {
    // Define the main class for the application
    mainClassName = "com.ibtsoft.hercule.app.App"
}
