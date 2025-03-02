package com.yooshyasha.mvpbussinescrm.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
data class User (
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null,

    var firstName: String? = null,

    var userName: String? = null,

    var hashedPassword: String? = null
) : UserDetails {
    override fun getUsername(): String {
        return userName!!
    }

    override fun getPassword(): String {
        return hashedPassword!!
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }
}