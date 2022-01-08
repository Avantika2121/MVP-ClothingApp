package com.clothingapp.clothingapp.controller;

import com.clothingapp.clothingapp.model.Gender;
import com.clothingapp.clothingapp.model.Item;
import com.clothingapp.clothingapp.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class GenderController {

    private GenderService genderService;

    @Autowired
    public void setGenderService(GenderService genderService) {
        this.genderService = genderService;
    }

    private static final Logger LOGGER = Logger.getLogger(GenderController.class.getName());

    //Return all items under that gender Id
    @GetMapping("/gender/{genderId}/items")
    public List<Item> getGenderItems(@PathVariable Long genderId) {
        LOGGER.info("calling getGenderItems from GenderController");
        return genderService.getGenderItems(genderId);
    }
    //Create Gender
    @PostMapping("/gender")
    public Gender createGender(@RequestBody Gender genderObject) {
        LOGGER.info("calling creteGender from GenderController");
        return genderService.createGender(genderObject);
    }
    //Allowing the user to create an item from a specifi gender, facilitating the creating process
    //by automatically assigning the item to that specific gender
    @PostMapping("/gender/{genderId}/items")
    public Item createItemFromGender (@PathVariable Long genderId, @RequestBody Item itemObject) {
        LOGGER.info("calling createItemFromGender from GenderController");
        return genderService.createItemFromGender(genderId, itemObject);
    }
}
