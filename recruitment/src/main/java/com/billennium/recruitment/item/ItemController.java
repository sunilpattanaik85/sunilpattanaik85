package com.billennium.recruitment.item;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.findAll();
    }
    
    @GetMapping("/getItem/{id}")
    public ItemDto getItem(@PathVariable("id")Long id) {
        return itemService.findById(id);
    }
    
    @GetMapping("/getItemsWithPrice")
    public List<Item> getItemsWithPrice() {
        return itemService.getItemsWithPrice();
    }
}
