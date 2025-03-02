package com.yooshyasha.mvpbussinescrm.repos

import com.yooshyasha.mvpbussinescrm.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersRepository : JpaRepository<User, UUID> {
    fun findUserById(id: UUID): User?

    fun findUserByUserName(username: String): User?

    fun existsByUserName(username: String): Boolean
}