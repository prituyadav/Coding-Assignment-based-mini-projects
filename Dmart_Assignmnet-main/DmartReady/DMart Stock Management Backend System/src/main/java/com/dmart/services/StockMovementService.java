package com.dmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmart.entities.StockMovement;
import com.dmart.exceptions.NotFoundException;
import com.dmart.repositories.StockMovementRepository;

import java.util.List;

@Service
public class StockMovementService {

    private final StockMovementRepository stockMovementRepository;

    @Autowired
    public StockMovementService(StockMovementRepository stockMovementRepository) {
        this.stockMovementRepository = stockMovementRepository;
    }

    public List<StockMovement> getAllStockMovements() {
        return stockMovementRepository.findAll();
    }

    public StockMovement getStockMovementById(Long id) {
        return stockMovementRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("StockMovement not found with id: " + id));
    }

    public StockMovement createStockMovement(StockMovement stockMovement) {
        return stockMovementRepository.save(stockMovement);
    }

    public StockMovement updateStockMovement(Long id, StockMovement updatedStockMovement) {
        StockMovement existingStockMovement = getStockMovementById(id);
        existingStockMovement.setStockItem(updatedStockMovement.getStockItem());
        existingStockMovement.setSourceStoreLocation(updatedStockMovement.getSourceStoreLocation());
        existingStockMovement.setDestinationStoreLocation(updatedStockMovement.getDestinationStoreLocation());
        existingStockMovement.setQuantity(updatedStockMovement.getQuantity());
        existingStockMovement.setTimestamp(updatedStockMovement.getTimestamp());
        return stockMovementRepository.save(existingStockMovement);
    }

    public void deleteStockMovement(Long id) {
        StockMovement stockMovement = getStockMovementById(id);
        stockMovementRepository.delete(stockMovement);
    }
}
