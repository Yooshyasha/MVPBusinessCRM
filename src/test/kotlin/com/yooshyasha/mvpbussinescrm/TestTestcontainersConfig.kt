package com.yooshyasha.mvpbussinescrm

import org.springframework.boot.SpringApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration
class TestTestcontainersConfig {
    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<Nothing> {
        return PostgreSQLContainer<Nothing>(DockerImageName.parse("postgres:latest"))
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplication.from(MvpBusinessCrmApplication::main).with(MvpBusinessCrmApplication::class.java).run(*args)
        }
    }
}