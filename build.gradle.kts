plugins {
    id("java")
    id("org.openjfx.javafxplugin") version "0.1.0" //это добавляет джаваФХ
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
    implementation("com.github.oshi:oshi-core:6.9.2") //это добавляет сам осхи
    implementation("org.slf4j:slf4j-simple:2.0.17") //это чтобы осхи не выдавал ошибку/не ныл. так называемый "интерфейс для логирования осхи"
}

javafx {
    version = "17"
    modules("javafx.controls", "javafx.fxml")   //это тоже добавляет джаваФХ
}

tasks.test {
    useJUnitPlatform()
}