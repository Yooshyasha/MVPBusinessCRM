package com.yooshyasha.mvpbussinescrm.services

import com.yooshyasha.mvpbussinescrm.entities.Client
import com.yooshyasha.mvpbussinescrm.repos.SalesRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*
import kotlin.test.assertContains
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class SaleServiceTest {
    @Mock
    private lateinit var clientsService: ClientsService

    @Mock
    private lateinit var salesRepository: SalesRepository

    @InjectMocks
    private lateinit var saleService: SaleService

    @Test
    fun createSale_createSalesSuccessTest() {
        val client = Client(id = UUID.randomUUID(), firstName = "Client1", mutableListOf())

        Mockito.`when`(clientsService.getClientById(client.id!!)).thenReturn(client)

        val sale = saleService.createSale(client.id!!, "Product")

        Mockito.verify(salesRepository, times(1)).save(sale)

        Mockito.verify(clientsService, times(1)).getClientById(client.id!!)
        Mockito.verify(clientsService, times(1)).updateClient(client)

        assertEquals(client.id, sale.client!!.id)
        assertContains(client.buyList, sale)
    }
}