package com.enzomendez.preppit.model;

import com.enzomendez.preppit.model.enums.ItemCategory;
import com.enzomendez.preppit.model.enums.ItemLocation;

import java.time.LocalDate;

public class StockItem {
    private Long id;
    private String name;
    private ItemCategory category;
    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private ItemLocation storageLocation;
}
