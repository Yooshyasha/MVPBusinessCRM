package com.yooshyasha.mvpbussinescrm.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import jakarta.persistence.*
import java.util.*

@Entity
data class Sale(
    @Id @GeneratedValue(strategy = GenerationType.AUTO) var id: UUID? = null,
    var productName: String? = null,

    @ManyToOne @JsonBackReference var client: Client? = null,
)