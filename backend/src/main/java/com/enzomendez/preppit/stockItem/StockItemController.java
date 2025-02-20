package com.enzomendez.preppit.stockItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/stock-item")
public class StockItemController {

    private final StockItemService itemService;

    @Autowired
    public StockItemController(StockItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public List<StockItem> getItems() {
        return itemService.getStockItems();
    }
}
