package com.dmart.entities;
import java.time.LocalDateTime;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "stock_movement")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "stock_item_id", nullable = false)
    private StockItem stockItem;

    @ManyToOne
    @JoinColumn(name = "source_store_location_id", nullable = false)
    private StoreLocation sourceStoreLocation;

    @ManyToOne
    @JoinColumn(name = "destination_store_location_id", nullable = false)
    private StoreLocation destinationStoreLocation;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    // Constructors, getters, and setters
}
