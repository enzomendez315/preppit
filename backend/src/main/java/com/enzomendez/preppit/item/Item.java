package com.enzomendez.preppit.item;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import jakarta.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    private Long id;
    private String name;
    private ItemCategory category;

    public Item() {}

    public Item(Long id, String name, ItemCategory category) {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    public Item(String name, ItemCategory category) {
        this.name = name;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }
}
