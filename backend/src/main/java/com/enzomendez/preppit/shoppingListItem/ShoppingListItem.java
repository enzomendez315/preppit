package com.enzomendez.preppit.shoppingListItem;

import com.enzomendez.preppit.item.Item;
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

    @ManyToOne
    private Item item;

    private Boolean purchased;
    private ItemPriority priority;
    private Integer desiredQuantity;

    public ShoppingListItem() {}

    public ShoppingListItem(Long id,
                            Item item,
                            Boolean purchased,
                            ItemPriority priority,
                            Integer desiredQuantity) {
        this.id = id;
        this.item = item;
        this.purchased = purchased;
        this.priority = priority;
        this.desiredQuantity = desiredQuantity;
    }

    public ShoppingListItem(Item item,
                            Boolean purchased,
                            ItemPriority priority,
                            Integer desiredQuantity) {
        this.item = item;
        this.purchased = purchased;
        this.priority = priority;
        this.desiredQuantity = desiredQuantity;
    }

    public Long getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
                ", purchased=" + purchased +
                ", priority=" + priority +
                ", desiredQuantity=" + desiredQuantity +
                '}';
    }
}
