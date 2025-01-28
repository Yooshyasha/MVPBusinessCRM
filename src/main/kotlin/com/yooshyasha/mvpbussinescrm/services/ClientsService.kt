package com.yooshyasha.mvpbussinescrm.services

import com.yooshyasha.mvpbussinescrm.entities.Client
import com.yooshyasha.mvpbussinescrm.repos.ClientsRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClientsService(
    private val clientsRepository: ClientsRepository,
) {
    fun getClientsList(): List<Client> {
        return clientsRepository.findAll()
    }

    fun updateClient(newClient: Client) {
        clientsRepository.save(newClient)
    }

    fun getClientById(id: UUID): Client? {
        return clientsRepository.findClientById(id)
    }
}