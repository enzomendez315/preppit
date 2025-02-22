package com.enzomendez.preppit.stockItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stock-items")
public class StockItemController {

    private final StockItemService stockItemService;

    @Autowired
    public StockItemController(StockItemService stockItemService) {
        this.stockItemService = stockItemService;
    }

    @GetMapping
    public List<StockItem> getStockItems() {
        return stockItemService.getStockItems();
    }

    @GetMapping("/{id}")
    public StockItem getStockItem(@PathVariable Long id) {
        return stockItemService.getStockItem(id);
    }

    @PostMapping
    public StockItem createStockItem(@RequestBody StockItem stockItem) {
        return stockItemService.saveStockItem(stockItem);
    }

    @DeleteMapping("/{id}")
    public void deleteStockItem(@PathVariable Long id) {
        stockItemService.deleteStockItem(id);
    }
}
