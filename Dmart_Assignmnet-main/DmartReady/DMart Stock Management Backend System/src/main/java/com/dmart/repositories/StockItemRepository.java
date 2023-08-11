package com.dmart.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmart.entities.StockItem;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {
}
