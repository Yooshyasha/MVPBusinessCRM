package com.yooshyasha.mvpbussinescrm.controllers

import com.yooshyasha.mvpbussinescrm.dto.SaleDTO
import com.yooshyasha.mvpbussinescrm.entities.Sale
import com.yooshyasha.mvpbussinescrm.services.SaleService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/sale")
class SaleController(
    private val saleService: SaleService,
) {
    @GetMapping("/all")
    fun getAllSales(): ResponseEntity<List<Sale>> {
        return ResponseEntity.ok(saleService.getSales())
    }

    @GetMapping("/{saleId}")
    fun getSale(@PathVariable saleId: UUID): ResponseEntity<Sale> {
        return ResponseEntity.ok(saleService.getSaleById(saleId))
    }

    @PutMapping
    fun updateSale(@RequestBody sale: Sale): ResponseEntity<Sale> {
        saleService.updateSale(sale)
        return ResponseEntity.ok(sale)
    }

    @PostMapping("/create")
    fun createSale(@RequestBody sale: SaleDTO): ResponseEntity<Sale> {
        return ResponseEntity.ok(saleService.createSale(UUID.fromString(sale.clientId), sale.productName))
    }
}