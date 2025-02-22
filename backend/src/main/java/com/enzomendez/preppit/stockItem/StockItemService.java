package com.enzomendez.preppit.stockItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockItemService {

    private final StockItemRepository stockItemRepository;

    @Autowired
    public StockItemService(StockItemRepository stockItemRepository) {
        this.stockItemRepository = stockItemRepository;
    }

    public List<StockItem> getStockItems() {
        return stockItemRepository.findAll();
    }

    public StockItem getStockItem(Long id) {
        return stockItemRepository.findById(id).orElse(null);
    }

    public StockItem saveStockItem(StockItem stockItem) {
        String normalizedName = normalizeName(stockItem.getName());
        Optional<StockItem> stockItemOptional = stockItemRepository
                .findByNormalizedName(normalizedName);
        if (stockItemOptional.isPresent()) {
            throw new IllegalArgumentException("Stock item already exists.");
        }
        return stockItemRepository.save(stockItem);
    }

    private String normalizeName(String name) {
        return name.trim().toLowerCase();
    }
}
