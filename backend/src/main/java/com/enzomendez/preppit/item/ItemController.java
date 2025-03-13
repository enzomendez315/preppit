package com.enzomendez.preppit.item;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;
    private final RedisTemplate<String, Item> redisTemplate;
    private static final String STRING_KEY_PREFIX = "preppit:items:";


    @Autowired
    public ItemController(ItemService itemService, RedisTemplate<String, Item> redisTemplate) {
        this.itemService = itemService;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @GetMapping("/{id}")
    public Item getItem(@PathVariable Long id) {
        // Check if item is cached
        String key = STRING_KEY_PREFIX + id;
        Item cachedItem = redisTemplate.opsForValue().get(key);
        if (cachedItem != null) {
            return cachedItem;
        }
        // Retrieve item from database and cache it
        Item item = itemService.getItem(id);
        redisTemplate.opsForValue().set(key, item);
        return item;
    }

    @PostMapping
    public Item createItem(@RequestBody Item item) {
        Item savedItem = itemService.saveItem(item);
        // Cache the new item
        String key = STRING_KEY_PREFIX + savedItem.getId();
        redisTemplate.opsForValue().set(key, savedItem);
        return savedItem;
    }

    @PutMapping("/{id}")
    public Item updateItem(
            @PathVariable Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ItemCategory category) {
        Item updatedItem = itemService.updateItem(id, name, category);
        // Update cache
        String key = STRING_KEY_PREFIX + updatedItem.getId();
        redisTemplate.opsForValue().set(key, updatedItem);
        return  updatedItem;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        // Remove from cache
        String key = STRING_KEY_PREFIX + id;
        redisTemplate.delete(key);
    }
}
