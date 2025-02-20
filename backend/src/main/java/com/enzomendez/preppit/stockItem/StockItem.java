package com.enzomendez.preppit.stockItem;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import com.enzomendez.preppit.shared.enums.ItemLocation;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "stock_item")
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
    private String name;
    private ItemCategory category;
    private LocalDate purchaseDate;
    private LocalDate expirationDate;
    private ItemLocation storageLocation;

    public StockItem() {}

    public StockItem(Long id, String name,
                     ItemCategory category,
                     LocalDate purchaseDate,
                     LocalDate expirationDate,
                     ItemLocation storageLocation) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.storageLocation = storageLocation;
    }

    public StockItem(String name,
                     ItemCategory category,
                     LocalDate purchaseDate,
                     LocalDate expirationDate,
                     ItemLocation storageLocation) {
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.expirationDate = expirationDate;
        this.storageLocation = storageLocation;
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

    @Override
    public String toString() {
        return "StockItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", purchaseDate=" + purchaseDate +
                ", expirationDate=" + expirationDate +
                ", storageLocation=" + storageLocation +
                '}';
    }
}
