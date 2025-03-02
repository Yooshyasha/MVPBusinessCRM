package com.yooshyasha.mvpbussinescrm.services

import com.yooshyasha.mvpbussinescrm.entities.User
import com.yooshyasha.mvpbussinescrm.repos.UsersRepository
import com.yooshyasha.mvpbussinescrm.security.JwtUtil
import jakarta.security.auth.message.AuthException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


@Service
class AuthService(
    private val jwtUtil: JwtUtil,
    private val userService: UserService,
    private val passwordEncoder: BCryptPasswordEncoder,
    private val usersRepository: UsersRepository,
) {
    fun generateToken(username: String): String {
        val userDetails = userService.getUserByUsername(username)

        return generateToken(userDetails)
    }

    fun generateToken(userDetails: UserDetails): String {
        return jwtUtil.generateToken(userDetails)
    }

    fun login(username: String, password: String): String {
        val userDetails = userService.getUserByUsername(username)

        if (!passwordEncoder.matches(password, userDetails.hashedPassword)) {
            throw AuthException("Wrong password")
        }

        return jwtUtil.generateToken(userDetails)
    }

    fun register(username: String, password: String): String {
        if (username == "" || password == "" || usersRepository.existsByUserName(username)) {
            throw AuthException("Wrong username or password")
        }

        val hashedPassword = passwordEncoder.encode(password)

        val user = User(
            firstName = "",
            userName = username,
            hashedPassword = hashedPassword,
        )

        userService.saveUser(user)

        return jwtUtil.generateToken(user)
    }
}