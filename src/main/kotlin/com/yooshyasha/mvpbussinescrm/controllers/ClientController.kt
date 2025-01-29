package com.yooshyasha.mvpbussinescrm.controllers

import com.yooshyasha.mvpbussinescrm.entities.Client
import com.yooshyasha.mvpbussinescrm.services.ClientsService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/client")
class ClientController(
    private val clientsService: ClientsService,
) {
    @GetMapping("/{clientId}")
    fun getClient(@PathVariable clientId: String): ResponseEntity<Client> {
        return ResponseEntity.ok(clientsService.getClientById(UUID.fromString(clientId)))
    }

    @PutMapping()
    fun updateClient(@RequestBody client: Client): ResponseEntity<Client> {
        clientsService.updateClient(client)
        return ResponseEntity.ok(client)
    }

    @GetMapping("/all")
    fun getAllClients(): ResponseEntity<List<Client>> {
        return ResponseEntity.ok(clientsService.getClientsList())
    }
}