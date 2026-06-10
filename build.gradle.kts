plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("net.dv8tion:JDA:6.4.2") //Neuste Version stand 08.06.2026
    implementation("com.squareup.okhttp3:okhttp:5.4.0") //Neuste Version stand 10.06.2026
}

tasks.test {
    useJUnitPlatform()
}