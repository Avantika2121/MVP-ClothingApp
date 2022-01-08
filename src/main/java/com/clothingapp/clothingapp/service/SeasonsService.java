package com.clothingapp.clothingapp.service;

import com.clothingapp.clothingapp.exception.InformationExistException;
import com.clothingapp.clothingapp.exception.InformationNotFoundException;
import com.clothingapp.clothingapp.model.Seasons;
import com.clothingapp.clothingapp.model.Item;
import com.clothingapp.clothingapp.repository.SeasonsRepository;
import com.clothingapp.clothingapp.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class SeasonsService {

    private static final Logger LOGGER = Logger.getLogger(SeasonsService.class.getName());

    public SeasonsRepository seasonsRepository;
    public ItemRepository itemRepository;

    @Autowired
    public void setSeasonsRepository(SeasonsRepository seasonsRepository) {
        this.seasonsRepository = seasonsRepository;
    }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getSeasonsItems(Long seasonsId) {
        LOGGER.info("calling getSeasonItems from SeasonsService");
        Optional<Seasons> seasons = seasonsRepository.findById(seasonsId);
        if (seasons.isPresent()) {
            return seasons.get().getItemList();
        } else {
            throw new InformationNotFoundException("season with id of " + seasonsId + " was not found");
        }
    }

    public Seasons createSeason(Seasons seasonsObject) {
        LOGGER.info("calling createSeason from the SeasonsService");
        Optional<Seasons> seasons = seasonsRepository.findByName(seasonsObject.getName());
        if (seasons.isPresent()) {
            throw new InformationExistException("season with name of " + seasonsObject.getName() + " already exists");
        } else {
            return seasonsRepository.save(seasonsObject);
        }
    }

    public Item createItemFromSeasons(Long seasonsId, Item itemObject) {
        LOGGER.info("calling createItemFromSeasons from seasonsService");
        Optional<Seasons> seasons = seasonsRepository.findById(seasonsId);
        if (seasons.isPresent()) {
            Optional<Item> item = itemRepository.findByName(itemObject.getName());
            if (item.isPresent()) {
                throw new InformationExistException("item with name " + itemObject.getName() + " already exists");
            } else {
                itemObject.setSeasons(seasonsRepository.findById(seasonsId).get());
                return itemRepository.save(itemObject);
            }
        } else {
            throw new InformationNotFoundException("gender with id of " + seasonsId + "does not exists");
        }

    }
}
