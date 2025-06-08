package com.example.shoppinglist.service;

import com.example.shoppinglist.model.ShoppingItem;
import com.example.shoppinglist.repository.ShoppingItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingItemService {

    private final ShoppingItemRepository repository;

    public ShoppingItemService(ShoppingItemRepository repository) {
        this.repository = repository;
    }

    public List<ShoppingItem> getAllItems() {
        return repository.findAll();
    }

    public ShoppingItem addItem(String name) {
        return repository.save(new ShoppingItem(name));
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }

    public Optional<ShoppingItem> markAsPurchased(Long id) {
        Optional<ShoppingItem> item = repository.findById(id);
        item.ifPresent(i -> {
            i.setPurchased(true);
            repository.save(i);
        });
        return item;
    }
}
