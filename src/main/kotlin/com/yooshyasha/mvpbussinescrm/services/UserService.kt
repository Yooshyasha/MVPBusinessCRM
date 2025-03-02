package com.yooshyasha.mvpbussinescrm.services

import com.yooshyasha.mvpbussinescrm.entities.User
import com.yooshyasha.mvpbussinescrm.repos.UsersRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService(
    private val usersRepository: UsersRepository,
) {
    fun getUserById(userId: UUID): User {
        return usersRepository.findUserById(userId) ?: throw ClassNotFoundException("User not found with id: $userId")
    }

    fun getUserByUsername(username: String): User {
        return usersRepository.findUserByUserName(username)
            ?: throw ClassNotFoundException("User not found with username: $username")
    }

    fun getAllUsers(): List<User> {
        return usersRepository.findAll()
    }

    fun saveUser(user: User) {
        usersRepository.save(user)
    }

    fun updateUser(user: User) {
        usersRepository.save(user)
    }

    fun deleteUserById(userId: UUID) {
        usersRepository.deleteById(userId)
    }
}