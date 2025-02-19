package com.enzomendez.preppit.stockItem;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import com.enzomendez.preppit.shared.enums.ItemLocation;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StockItemService {

    public List<StockItem> getStockItems() {
        return List.of(
                new StockItem(
                        2L,
                        "tomato",
                        ItemCategory.FOOD,
                        LocalDate.of(2025, 2, 17),
                        LocalDate.of(2025, 2, 23),
                        ItemLocation.KITCHEN
                ));
    }
}
