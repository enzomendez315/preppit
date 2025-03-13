package com.enzomendez.preppit.item;

import com.enzomendez.preppit.shared.enums.ItemCategory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item saveItem(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public Item updateItem(Long id, String name, ItemCategory category) {
        Item item = itemRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("Item with ID " + id + " not found"));

        if (name != null && !name.isEmpty() && !Objects.equals(name, item.getName())) {
            item.setName(name);
        }

        if (category != null && !Objects.equals(category, item.getCategory())) {
            item.setCategory(category);
        }

        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
