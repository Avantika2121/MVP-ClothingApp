package com.clothingapp.clothingapp.service;

import com.clothingapp.clothingapp.ClothingAppApplication;
import com.clothingapp.clothingapp.model.Category;
import com.clothingapp.clothingapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClothingAppApplication.class)

public class CategoryTest {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryService categoryService;


    @Test
    void getCategory() {
        String expected = "Tiara";
        String actual = categoryService.getCategory(3L).getName();
        //compares the expected value with actual value in system is same or not
        assertEquals(expected, actual);
    }

    @Test
    void deleteCategory() {
       categoryService.deleteCategory(4L);
        Optional<Category> actual = categoryRepository.findById(4L);
        //Returns boolean true if the value is not present/deleted
        assertTrue(actual.isEmpty());
    }

}
