package com.enzomendez.preppit.stockItem;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import com.enzomendez.preppit.shared.enums.ItemLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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
}
