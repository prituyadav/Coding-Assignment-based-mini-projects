package com.dmart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmart.entities.StoreLocation;

@Repository
public interface StoreLocationRepository extends JpaRepository<StoreLocation, Long> {
}
