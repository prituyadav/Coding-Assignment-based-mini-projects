package com.dmart.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmart.entities.StoreLocation;
import com.dmart.exceptions.NotFoundException;
import com.dmart.repositories.StoreLocationRepository;

import java.util.List;

@Service
public class StoreLocationService {

    private final StoreLocationRepository storeLocationRepository;

    @Autowired
    public StoreLocationService(StoreLocationRepository storeLocationRepository) {
        this.storeLocationRepository = storeLocationRepository;
    }

    public List<StoreLocation> getAllStoreLocations() {
        return storeLocationRepository.findAll();
    }

    public StoreLocation getStoreLocationById(Long id) {
        return storeLocationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("StoreLocation not found with id: " + id));
    }

    public StoreLocation createStoreLocation(StoreLocation storeLocation) {
        return storeLocationRepository.save(storeLocation);
    }

    public StoreLocation updateStoreLocation(Long id, StoreLocation updatedStoreLocation) {
        StoreLocation existingStoreLocation = getStoreLocationById(id);
        existingStoreLocation.setName(updatedStoreLocation.getName());
        existingStoreLocation.setAddress(updatedStoreLocation.getAddress());
        existingStoreLocation.setContactDetails(updatedStoreLocation.getContactDetails());
        return storeLocationRepository.save(existingStoreLocation);
    }

    public void deleteStoreLocation(Long id) {
        StoreLocation storeLocation = getStoreLocationById(id);
        storeLocationRepository.delete(storeLocation);
    }
}
