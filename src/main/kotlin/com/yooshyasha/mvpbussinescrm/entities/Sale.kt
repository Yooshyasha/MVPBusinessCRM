package com.yooshyasha.mvpbussinescrm.entities

import jakarta.persistence.*
import java.util.*

@Entity
data class Sale(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: UUID? = null,
    var productName: String? = null,
    @ManyToOne var client: Client? = null,
)