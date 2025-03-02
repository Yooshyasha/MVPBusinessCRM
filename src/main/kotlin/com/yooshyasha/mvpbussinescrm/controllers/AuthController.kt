package com.yooshyasha.mvpbussinescrm.controllers

import com.yooshyasha.mvpbussinescrm.dto.controller.RequestLogin
import com.yooshyasha.mvpbussinescrm.dto.controller.RequestRegister
import com.yooshyasha.mvpbussinescrm.dto.controller.ResponseLogin
import com.yooshyasha.mvpbussinescrm.dto.controller.ResponseRegister
import com.yooshyasha.mvpbussinescrm.security.JwtUtil
import com.yooshyasha.mvpbussinescrm.services.AuthService
import com.yooshyasha.mvpbussinescrm.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/jwt/auth")
class AuthController(
    private val jwtUtil: JwtUtil,
    private val userService: UserService,
    private val authService: AuthService,
) {
    @PostMapping("/login")
    fun login(@RequestBody loginData: RequestLogin): ResponseEntity<ResponseLogin> {
        val result = authService.login(loginData.username, loginData.password)

        return ResponseEntity.ok(
            ResponseLogin(
                username = loginData.username,
                jwtToken = result,
            )
        )
    }

    @PostMapping("/register")
    fun register(@RequestBody registerData: RequestRegister): ResponseEntity<ResponseRegister> {
        val result = authService.register(registerData.username, registerData.password)

        return ResponseEntity.ok(
            ResponseRegister(
                username = registerData.username,
                jwtToken = result,
            )
        )
    }
}