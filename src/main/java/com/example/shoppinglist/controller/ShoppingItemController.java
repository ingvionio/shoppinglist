package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.ShoppingItem;
import com.example.shoppinglist.service.ShoppingItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ShoppingItemController {

    private final ShoppingItemService service;

    public ShoppingItemController(ShoppingItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<ShoppingItem> getAllItems() {
        return service.getAllItems();
    }

    @PostMapping
    public ShoppingItem addItem(@RequestBody String name) {
        return service.addItem(name);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
    }

    @PatchMapping("/{id}/toggle")
    public ResponseEntity<?> toggleBought(@PathVariable Long id) {
        return service.markAsPurchased(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
