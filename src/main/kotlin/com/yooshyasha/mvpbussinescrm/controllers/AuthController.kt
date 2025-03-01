package com.yooshyasha.mvpbussinescrm.controllers

import com.yooshyasha.mvpbussinescrm.dto.controller.RequestLogin
import com.yooshyasha.mvpbussinescrm.dto.controller.ResponseLogin
import com.yooshyasha.mvpbussinescrm.security.JwtUtil
import com.yooshyasha.mvpbussinescrm.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/jwt/auth")
class AuthController (
    private val jwtUtil: JwtUtil,
    private val userService: UserService,
) {
//    @PostMapping("/login")
//    fun login(@RequestBody loginData: RequestLogin): ResponseEntity<ResponseLogin> {
//
//    }
}