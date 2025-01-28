package com.yooshyasha.mvpbussinescrm.entities

import jakarta.persistence.*
import java.util.*

@Entity
data class Client(
    @Id @GeneratedValue(strategy = GenerationType.UUID) val id: UUID? = null,
    var firstName: String? = null,
    @OneToMany val buyList: List<Sale> = listOf(),
)