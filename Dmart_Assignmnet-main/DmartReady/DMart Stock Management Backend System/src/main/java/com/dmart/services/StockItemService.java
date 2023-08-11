package com.dmart.services;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.dmart.entities.StockItem;
import com.dmart.exceptions.NotFoundException;
import com.dmart.repositories.StockItemRepository;

import java.util.List;

@Service
public class StockItemService {

    private final StockItemRepository stockItemRepository;

    @Autowired
    public StockItemService(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    public List<StockItem> getAllStockItems() {
        return stockItemRepository.findAll();
    }

    public StockItem getStockItemById(Long id) {
        return stockItemRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("StockItem not found with id: " + id));

    }

    public StockItem createStockItem(StockItem stockItem) {
        return stockItemRepository.save(stockItem);
    }

    public StockItem updateStockItem(Long id, StockItem updatedStockItem) {
        StockItem existingStockItem = getStockItemById(id);
        existingStockItem.setName(updatedStockItem.getName());
        existingStockItem.setDescription(updatedStockItem.getDescription());
        existingStockItem.setQuantity(updatedStockItem.getQuantity());
        existingStockItem.setUnitPrice(updatedStockItem.getUnitPrice());
        return stockItemRepository.save(existingStockItem);
    }

    public void deleteStockItem(Long id) {
        StockItem stockItem = getStockItemById(id);
        stockItemRepository.delete(stockItem);
    }
}
