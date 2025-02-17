package com.enzomendez.preppit.model;

import com.enzomendez.preppit.model.enums.ItemCategory;
import com.enzomendez.preppit.model.enums.ItemPriority;

public class ShoppingListItem {
    private Long id;
    private String name;
    private ItemCategory category;
    private Boolean purchased;
    private ItemPriority priority;
    private Integer desiredQuantity;
}
