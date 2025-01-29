package com.yooshyasha.mvpbussinescrm.controllers

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

    @PutMapping("/{saleId}")
    fun updateSale(@RequestBody sale: Sale, @PathVariable saleId: UUID): ResponseEntity<Sale> {
        saleService.updateSale(sale)
        return ResponseEntity.ok(sale)
    }
}