package com.clothingapp.clothingapp.service;

import com.clothingapp.clothingapp.exception.InformationExistException;
import com.clothingapp.clothingapp.exception.InformationNotFoundException;
import com.clothingapp.clothingapp.model.Item;
import com.clothingapp.clothingapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@Service
public class ItemService {

    private static final Logger LOGGER = Logger.getLogger(ItemService.class.getName());

    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    // DIRECT ITEM CRUD
    //.../items   == Get all items regardless of Cat, Gender, or Season
    public List<Item> getItemList() {
        LOGGER.info("calling getItemList from ItemService");
        return itemRepository.findAll();
    }
    //.../items   == Create an item (You will have to specify Cat, Gender and Season
    public Item createItem(Item itemObject) {
        LOGGER.info("calling createItem from ItemService");
        Optional<Item> item = itemRepository.findByName(itemObject.getName());
        if (item.isPresent()) {
            throw new InformationExistException("item with name"+ itemObject.getName() + " already exists");
        } else {
            return itemRepository.save(itemObject);
        }

    }
    //...items/{itemId}  == Update an item knowing the item id
    public Item updateItem(Long itemId, Item itemObject) {
        LOGGER.info("calling update an object from ItemService");
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            item.get().setName(itemObject.getName());
            item.get().setDescription(itemObject.getDescription());
            return itemRepository.save(item.get());
        } else {
            throw new InformationNotFoundException("unable to find an item with id of " + itemId);
        }
    }
    //...items/{itemId}  == Get a specific item by its id
    public Item getItem (Long itemId) {
        LOGGER.info("calling getItem from ItemService");
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            return itemRepository.findById(itemId).get();
        } else {
            throw new InformationNotFoundException("item with id of "+ itemId + "could not be found");
        }
    }
    //...items/{itemId}  ==Delete an specific item
    public String deleteItem (Long itemId) {
        LOGGER.info("calling deleteItem from ItemService");
        Optional<Item> item = itemRepository.findById(itemId);
        if (item.isPresent()) {
            itemRepository.deleteById(itemId);
            return "Item with id of " + itemId + " has been deleted";
        } else {
            throw new InformationNotFoundException("item with id of " + itemId + " couldn't be found");
        }
    }

}
