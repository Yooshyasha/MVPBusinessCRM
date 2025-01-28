package com.yooshyasha.mvpbussinescrm.services

import com.yooshyasha.mvpbussinescrm.entities.Sale
import com.yooshyasha.mvpbussinescrm.repos.SalesRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class SaleService(
    private val clientsService: ClientsService,
    private val salesRepository: SalesRepository,
) {
    fun getSales(): List<Sale> {
        return salesRepository.findAll()
    }

    fun updateSale(newSale: Sale) {
        salesRepository.save(newSale)
    }

    fun getSaleById(id: UUID): Sale? {
        return salesRepository.findSaleById(id)
    }

    fun createSale(clientId: UUID, productName: String): Sale {
        val sale = Sale(productName = productName, client = clientsService.getClientById(clientId))
        salesRepository.save(sale)
        return sale
    }
}