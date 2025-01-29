package com.yooshyasha.mvpbussinescrm.entities

import jakarta.persistence.*
import java.util.*

@Entity
data class Client(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) val id: UUID? = null,
    var firstName: String? = null,
    @OneToMany(fetch = FetchType.EAGER) var buyList: List<Sale> = listOf(),
)