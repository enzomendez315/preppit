package com.enzomendez.preppit.stockItem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockItemRepository extends JpaRepository<StockItem, Long> {
    @Query("SELECT s FROM StockItem s WHERE s.name = ?1")
    Optional<StockItem> findByNormalizedName(String name);
}
