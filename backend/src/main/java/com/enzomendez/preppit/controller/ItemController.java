package com.enzomendez.preppit.controller;

import com.enzomendez.preppit.model.StockItem;
import com.enzomendez.preppit.model.enums.ItemCategory;
import com.enzomendez.preppit.model.enums.ItemLocation;
import com.enzomendez.preppit.model.enums.ItemPriority;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/item")
public class ItemController {

    @GetMapping("/{id}")
    public List<StockItem> getItem() {
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
