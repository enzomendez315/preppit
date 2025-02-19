package com.enzomendez.preppit.shoppingListItem;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import com.enzomendez.preppit.shared.enums.ItemPriority;
import jakarta.persistence.*;

@Entity
@Table(name = "shopping_list_item")
public class ShoppingListItem {
    @Id
    @SequenceGenerator(
            name = "shopping_list_item_sequence",
            sequenceName = "shopping_list_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shopping_list_item_sequence"
    )
    private Long id;
    private String name;
    private ItemCategory category;
    private Boolean purchased;
    private ItemPriority priority;
    private Integer desiredQuantity;

    public ShoppingListItem() {}

    public ShoppingListItem(Long id,
                            String name,
                            ItemCategory category,
                            Boolean purchased,
                            ItemPriority priority,
                            Integer desiredQuantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.purchased = purchased;
        this.priority = priority;
        this.desiredQuantity = desiredQuantity;
    }

    public ShoppingListItem(String name,
                            ItemCategory category,
                            Boolean purchased,
                            ItemPriority priority,
                            Integer desiredQuantity) {
        this.name = name;
        this.category = category;
        this.purchased = purchased;
        this.priority = priority;
        this.desiredQuantity = desiredQuantity;
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

    public Boolean getPurchased() {
        return purchased;
    }

    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    public ItemPriority getPriority() {
        return priority;
    }

    public void setPriority(ItemPriority priority) {
        this.priority = priority;
    }

    public Integer getDesiredQuantity() {
        return desiredQuantity;
    }

    public void setDesiredQuantity(Integer desiredQuantity) {
        this.desiredQuantity = desiredQuantity;
    }

    @Override
    public String toString() {
        return "ShoppingListItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", purchased=" + purchased +
                ", priority=" + priority +
                ", desiredQuantity=" + desiredQuantity +
                '}';
    }
}
