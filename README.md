# msa


# Intellij 에서의 Docker build 방법 
    
    - Service 모듈의 build.gralde 에 id "com.google.cloud.tools.jib" version "3.1.4" plug in 을 설정한다.

    plugins {
        id 'java'
        id 'eclipse'
        id 'idea'
        id "com.google.cloud.tools.jib" version "3.1.4"
    }

    repositories {
        mavenCentral()
    }

    ext {
        set('springCloudVersion', "2021.0.0")
    }

    dependencies {
        implementation project(':common')
        implementation 'org.springframework.cloud:spring-cloud-starter-netflix-eureka-server'
        implementation group: 'org.springframework.boot', name: 'spring-boot-starter-security'

        testImplementation 'org.springframework.boot:spring-boot-starter-test'
    }
