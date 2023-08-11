package com.dmart.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.dmart.entities.StoreLocation;
import com.dmart.services.StoreLocationService;

import java.util.List;

@RestController
@RequestMapping("/store-locations")
public class StoreLocationController {

    private final StoreLocationService storeLocationService;

    @Autowired
    public StoreLocationController(StoreLocationService storeLocationService) {
        this.storeLocationService = storeLocationService;
    }

    @GetMapping
    public List<StoreLocation> getAllStoreLocations() {
        return storeLocationService.getAllStoreLocations();
    }

    @GetMapping("/{id}")
    public StoreLocation getStoreLocationById(@PathVariable Long id) {
        return storeLocationService.getStoreLocationById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StoreLocation createStoreLocation(@RequestBody StoreLocation storeLocation) {
        return storeLocationService.createStoreLocation(storeLocation);
    }

    @PutMapping("/{id}")
    public StoreLocation updateStoreLocation(@PathVariable Long id, @RequestBody StoreLocation updatedStoreLocation) {
        return storeLocationService.updateStoreLocation(id, updatedStoreLocation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStoreLocation(@PathVariable Long id) {
        storeLocationService.deleteStoreLocation(id);
    }
}
