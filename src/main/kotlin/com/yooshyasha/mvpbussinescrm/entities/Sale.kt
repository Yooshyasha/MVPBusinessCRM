package com.yooshyasha.mvpbussinescrm.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.util.*

@Entity
data class Sale(
    @Id @GeneratedValue(strategy = GenerationType.UUID) var id: UUID? = null,
    var productName: String? = null,
)