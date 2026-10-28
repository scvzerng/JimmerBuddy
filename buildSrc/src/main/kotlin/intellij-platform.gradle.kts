plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.intellij.platform")
}

repositories {
    // 本地优先:跟 D:\github\jimmer fork 的 publishToMavenLocal(0.11.7.1)对齐
    // 改了 fork 代码后必须先 publish,这里才能拉到新版本
    mavenLocal()
    mavenCentral()
    intellijPlatform {
        releases()
        marketplace()
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        create(project.property("platformType").toString(), project.property("platformVersion").toString())
        bundledPlugin("com.intellij.java")
        bundledPlugin("org.jetbrains.kotlin")
        bundledPlugin("com.intellij.gradle")
        bundledPlugin("com.intellij.database")
    }
}

kotlin {
    jvmToolchain(17)
}