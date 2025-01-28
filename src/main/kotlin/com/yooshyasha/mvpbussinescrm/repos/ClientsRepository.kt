package com.yooshyasha.mvpbussinescrm.repos

import com.yooshyasha.mvpbussinescrm.entities.Client
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface ClientsRepository : JpaRepository<Client, UUID> {
    fun findClientById(id: UUID): Client?
}