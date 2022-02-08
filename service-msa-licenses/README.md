https://www.baeldung.com/spring-boot-security-autoconfiguration

1. security 를 이용해 authentication, authorize 룰 없애고 싶을 때 ()
   @SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
   spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration
2. configuring spring boot security
   spring.security.user.password=password


