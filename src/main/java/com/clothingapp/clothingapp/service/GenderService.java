package com.clothingapp.clothingapp.service;

import com.clothingapp.clothingapp.exception.InformationExistException;
import com.clothingapp.clothingapp.exception.InformationNotFoundException;
import com.clothingapp.clothingapp.model.Gender;
import com.clothingapp.clothingapp.model.Item;
import com.clothingapp.clothingapp.repository.GenderRepository;
import com.clothingapp.clothingapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class GenderService {

    private static final Logger LOGGER = Logger.getLogger(GenderService.class.getName());

    public GenderRepository genderRepository;
    public ItemRepository itemRepository;

    @Autowired
    public void setGenderRepository(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }
    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getGenderItems(Long genderId) {
        LOGGER.info("calling getGenderItems from GenderService");
        Optional<Gender> gender = genderRepository.findById(genderId);
        if (gender.isPresent()) {
            return gender.get().getItemList();
        } else {
            throw new InformationNotFoundException("gender with id of "+ genderId + " was not found");
        }
    }

    public Gender createGender(Gender genderObject) {
        LOGGER.info("calling createGender from the GenderService");
        Optional<Gender> gender = genderRepository.findByName(genderObject.getName());
        if (gender.isPresent()) {
            throw new InformationExistException("gender with name of " + genderObject.getName() + " already exists");
        } else {
            return genderRepository.save(genderObject);
        }
    }

    public Item createItemFromGender(Long genderId, Item itemObject) {
        LOGGER.info("calling createItemFromGender from genderService");
        Optional<Gender> gender = genderRepository.findById(genderId);
        if (gender.isPresent()) {
            Optional<Item> item = itemRepository.findByName(itemObject.getName());
            if (item.isPresent()) {
                throw new InformationExistException("item with name "+ itemObject.getName() + " already exists");
            } else {
                itemObject.setGender(genderRepository.findById(genderId).get());
                return itemRepository.save(itemObject);
            }
        } else {
            throw new InformationNotFoundException("gender with id of "+ genderId + "does not exists");
        }
        //This throws the correct error when the genderId doesn't exists but in the console, not in Postman, it might
        // be bc it's detecting from the from getGenderItems
    }
}
