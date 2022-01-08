package com.clothingapp.clothingapp.repository;

import com.clothingapp.clothingapp.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {


    Optional<Item> findByName (String name);

    List<Item> findByCategoryId(Long categoryId);

    Item findByNameAndIdIsNot(String name, Long itemId);
}
