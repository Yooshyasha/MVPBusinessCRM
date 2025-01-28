package com.yooshyasha.mvpbussinescrm.repos

import com.yooshyasha.mvpbussinescrm.entities.Sale
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SalesRepository : JpaRepository<Sale, UUID> {
    fun findSaleById(id: UUID): Sale?
}