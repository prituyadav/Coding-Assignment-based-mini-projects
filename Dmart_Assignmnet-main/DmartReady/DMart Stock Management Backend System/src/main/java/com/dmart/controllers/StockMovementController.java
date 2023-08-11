package com.dmart.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dmart.entities.StockMovement;
import com.dmart.services.StockMovementService;

import java.util.List;

@RestController
@RequestMapping("/stock-movements")
public class StockMovementController {

    private final StockMovementService stockMovementService;

    @Autowired
    public StockMovementController(StockMovementService stockMovementService) {
        this.stockMovementService = stockMovementService;
    }

    @GetMapping
    public List<StockMovement> getAllStockMovements() {
        return stockMovementService.getAllStockMovements();
    }

    @GetMapping("/{id}")
    public StockMovement getStockMovementById(@PathVariable Long id) {
        return stockMovementService.getStockMovementById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockMovement createStockMovement(@RequestBody StockMovement stockMovement) {
        return stockMovementService.createStockMovement(stockMovement);
    }

    @PutMapping("/{id}")
    public StockMovement updateStockMovement(@PathVariable Long id, @RequestBody StockMovement updatedStockMovement) {
        return stockMovementService.updateStockMovement(id, updatedStockMovement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStockMovement(@PathVariable Long id) {
        stockMovementService.deleteStockMovement(id);
    }
}
