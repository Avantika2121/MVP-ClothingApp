package com.clothingapp.clothingapp.controller;

import com.clothingapp.clothingapp.model.Item;
import com.clothingapp.clothingapp.model.Seasons;
import com.clothingapp.clothingapp.service.SeasonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class SeasonsController {

    private static final Logger LOGGER = Logger.getLogger(SeasonsController.class.getName());

    private SeasonsService seasonsService;

    @Autowired
    public void setSeasonsService(SeasonsService seasonsService) {
        this.seasonsService = seasonsService;
    }

    //Getting all the items within the category
    @GetMapping("/seasons/{seasonsId}")
    public List<Item> getSeasonItems(@PathVariable Long seasonsId) {
        LOGGER.info("calling getSeasonsItem from SeasonsController");
        return seasonsService.getSeasonsItems(seasonsId);
    }

    //Creating a season
    @PostMapping("/seasons")
    public Seasons createSeason(@RequestBody Seasons seasonsObject) {
        LOGGER.info("calling createSeason from SeasonsController");
        return seasonsService.createSeason(seasonsObject);
    }

    //Allowing the user to create an item from the seasons page. When this is done the item will automatically
    //belong to that specific season
    @PostMapping("/seasons/{seasonsId}/items")
    public Item createItemFromSeasons(@PathVariable Long seasonsId, @RequestBody Item itemObject) {
        LOGGER.info("calling createItemFromSeasons from SeasonsController");
        return seasonsService.createItemFromSeasons(seasonsId, itemObject);
    }

}
