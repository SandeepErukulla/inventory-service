package com.ecommerce.inventory_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    @GetMapping("/check/{productId}")
    public ResponseEntity<Boolean> checkStock(
            @PathVariable String productId,
            @RequestParam(defaultValue = "1") Integer quantity) {

        // Mock stock rule: "OUT-OF-STOCK" product IDs fail availability
        boolean isAvailable = !"OUT-OF-STOCK".equalsIgnoreCase(productId);
        return ResponseEntity.ok(isAvailable);
    }
}
