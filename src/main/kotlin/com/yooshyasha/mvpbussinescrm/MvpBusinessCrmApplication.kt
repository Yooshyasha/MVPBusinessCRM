package com.yooshyasha.mvpbussinescrm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MvpBusinessCrmApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<MvpBusinessCrmApplication>(*args)
        }
    }
}