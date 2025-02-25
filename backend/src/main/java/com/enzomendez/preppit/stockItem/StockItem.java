package com.enzomendez.preppit.stockItem;

import com.enzomendez.preppit.item.Item;
import com.enzomendez.preppit.shared.enums.ItemCategory;
import com.enzomendez.preppit.shared.enums.ItemLocation;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock_items")
public class StockItem {
    @Id
    @SequenceGenerator(
            name = "stock_item_sequence",
            sequenceName = "stock_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stock_item_sequence"
    )
    private Long id;

    @ManyToOne
    private Item item;

    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private ItemLocation storageLocation;
    private Integer quantity;

    public StockItem() {}

    public StockItem(Long id,
                     Item item,
                     LocalDate purchaseDate,
                     LocalDate expirationDate,
                     ItemLocation storageLocation,
                     Integer quantity) {
        this.id = id;
        this.item = item;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.storageLocation = storageLocation;
        this.quantity = quantity;
    }

    public StockItem(Item item,
                     LocalDate purchaseDate,
                     LocalDate expirationDate,
                     ItemLocation storageLocation,
                     Integer quantity) {
        this.item = item;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.storageLocation = storageLocation;
        this.quantity = quantity;
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

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public ItemLocation getStorageLocation() {
        return storageLocation;
    }

    public void setStorageLocation(ItemLocation storageLocation) {
        this.storageLocation = storageLocation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", storageLocation=" + storageLocation +
                ", quantity=" + quantity +
                '}';
    }
}
