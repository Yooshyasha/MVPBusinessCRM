package com.yooshyasha.mvpbussinescrm.controllers

import com.yooshyasha.mvpbussinescrm.entities.Sale
import com.yooshyasha.mvpbussinescrm.services.SaleService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class)
class SaleControllerTest {
    @Mock
    private lateinit var saleService: SaleService

    @InjectMocks
    private lateinit var saleController: SaleController


    @Test
    fun updateSaleTest() {
        val firstSale = Sale(id = UUID.randomUUID())
        firstSale.productName = "Product1"

        val response = saleController.updateSale(firstSale)

        Mockito.verify(saleService, Mockito.times(1)).updateSale(firstSale)

        assertEquals(firstSale, response.body)

        assertEquals(firstSale.productName, response.body?.productName)
    }
}