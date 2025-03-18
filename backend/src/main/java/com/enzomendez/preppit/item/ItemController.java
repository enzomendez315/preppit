package com.enzomendez.preppit.item;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        return itemService.getItem(id);
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }

    @PutMapping("/{id}")
    public Item updateItem(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ItemCategory category) {
        return  itemService.updateItem(id, name, category);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }
}
