package com.dmart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dmart.entities.StockItem;
import com.dmart.services.StockItemService;

import java.util.List;

@RestController
@RequestMapping("/stock-items")
public class StockItemController {

    private final StockItemService stockItemService;

    @Autowired
    public StockItemController(StockItemService stockItemService) {
        this.stockItemService = stockItemService;
    }

    @GetMapping
    public List<StockItem> getAllStockItems() {
        return stockItemService.getAllStockItems();
    }

    @GetMapping("/{id}")
    public StockItem getStockItemById(@PathVariable Long id) {
        return stockItemService.getStockItemById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StockItem createStockItem(@RequestBody StockItem stockItem) {
        return stockItemService.createStockItem(stockItem);
    }

    @PutMapping("/{id}")
    public StockItem updateStockItem(@PathVariable Long id, @RequestBody StockItem updatedStockItem) {
        return stockItemService.updateStockItem(id, updatedStockItem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStockItem(@PathVariable Long id) {
        stockItemService.deleteStockItem(id);
    }
}
