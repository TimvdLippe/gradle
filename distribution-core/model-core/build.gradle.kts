plugins {
    id("gradlebuild.distribution.api-java")
}

dependencies {
    api(project(":core-api"))
    api(project(":problems"))

    implementation(project(":base-services"))
    implementation(project(":logging"))
    implementation(project(":persistent-cache"))
    implementation(project(":base-services-groovy"))
    implementation(project(":messaging"))
    implementation(project(":snapshots"))

    implementation(libs.futureKotlin("stdlib"))
    implementation(libs.inject)
    implementation(libs.groovy)
    implementation(libs.slf4jApi)
    implementation(libs.guava)
    implementation(libs.commonsLang)
    implementation(libs.asm)

    testFixturesApi(testFixtures(project(":core")))
    testFixturesApi(testFixtures("org.gradle:diagnostics"))
    testFixturesApi("org.gradle:internal-integ-testing")
    testFixturesImplementation(libs.guava)
    testFixturesImplementation(libs.groovyAnt)
    testFixturesImplementation(libs.groovyDatetime)
    testFixturesImplementation(libs.groovyDateUtil)

    testImplementation(project(":process-services"))
    testImplementation(project(":file-collections"))
    testImplementation(project(":native"))
    testImplementation(project(":resources"))
    testImplementation(testFixtures(project(":core-api")))

    integTestImplementation("org.gradle:platform-base")

    testRuntimeOnly("org.gradle:distributions-core") {
        because("Tests instantiate DefaultClassLoaderRegistry which requires a 'gradle-plugins.properties' through DefaultPluginModuleRegistry")
    }
    integTestDistributionRuntimeOnly("org.gradle:distributions-native") {
        because("ModelRuleCachingIntegrationTest requires a rules implementation")
    }
}

strictCompile {
    ignoreRawTypes() // raw types used in public API
}

tasks.withType<JavaCompile>().configureEach {
    options.release.set(null as? Int)
    sourceCompatibility = "8"
    targetCompatibility = "8"
}


classycle {
    excludePatterns.add("org/gradle/model/internal/core/**")
    excludePatterns.add("org/gradle/model/internal/inspect/**")
    excludePatterns.add("org/gradle/api/internal/tasks/**")
    excludePatterns.add("org/gradle/model/internal/manage/schema/**")
    excludePatterns.add("org/gradle/model/internal/type/**")
    excludePatterns.add("org/gradle/api/internal/plugins/*")
}