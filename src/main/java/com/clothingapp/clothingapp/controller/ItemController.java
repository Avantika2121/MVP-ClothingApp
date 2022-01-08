package com.clothingapp.clothingapp.controller;

import com.clothingapp.clothingapp.model.Item;
import com.clothingapp.clothingapp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class ItemController {

    private static final Logger LOGGER = Logger.getLogger(ItemController.class.getName());

    private ItemService itemService;

    @Autowired
    public void setItemService(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/{itemId}")
    public Item getItem(@PathVariable Long itemId) {
        LOGGER.info("calling getItem from TestingController");
        return itemService.getItem(itemId);
    }
    @GetMapping("/items/")
    public List<Item> getItemList(@PathVariable Long itemId) {
        LOGGER.info("calling getItem from TestingController");
        return itemService.getItemList();
    }
    @PostMapping("/items")
    public Item createItem(@RequestBody Item itemObject) {
        LOGGER.info("calling create item from TestingController");
        return itemService.createItem(itemObject);
    }
    @PutMapping("/items/{itemId}")
    public Item updateItem(@PathVariable Long itemId, @RequestBody Item itemObject) {
        LOGGER.info("calling getItem from TestingController");
        return itemService.updateItem(itemId, itemObject);
    }
    @DeleteMapping("/items/{itemId}")
    public String deleteItem(@PathVariable Long itemId) {
        LOGGER.info("calling getItem from TestingController");
        return itemService.deleteItem(itemId);
    }

}
