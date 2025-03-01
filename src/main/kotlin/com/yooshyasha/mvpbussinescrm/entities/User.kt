package com.yooshyasha.mvpbussinescrm.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.*

@Entity
class User : UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id: UUID? = null

    var firstName: String? = null

    var username: String? = null
    var password: String? = null

    override fun getUsername(): String {
        return username!!
    }

    override fun getPassword(): String {
        return password!!
    }

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return mutableListOf()
    }
}