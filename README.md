# Clothing-App

Clothing app based on various seasons

**Introduction**

Clothing App is a database of clothing items where a user can select, create, update and remove the clothing items based
on his/her choice.

**ERD**


![image](https://user-images.githubusercontent.com/94148009/148087537-bbdbe690-b8e9-4ab9-96be-272948c2afd5.png)


****User Stories****

**Item Model**

1. As a User, I should be able to create an item and assign a category, season and gender.
2. As a User, I should be able to get an item based on its Id.
3. As a User, I should be able to get a list of all items.
4. As a User, I should be able to update an item.
5. As a User, I should be able delete an item.
6. As a User, I should be able to filter item based on its Category, Gender and Season.

**Category Model**

1. As a User, I should be able to create a category.
2. As a User, I should be able to update a category.
3. As a User, I should be able to get all categories.
4. As a User, I should be able to delete a category and all items within it.
5. As a User, I should be able to create an item from within a category, automatically assigning the item to that specific category.
6. As a User, I should be able to update an item of a specific category.
7. As a User, I should be able to delete an item belonging to a category.

**Seasons Model**

1. As a User, I should be able to create a season.
2. As a User, I should be able to get a season all the items within it.
3. As a user, I should be able to create an item from within a season, automatically assigning the item to that specific season.

**Gender Model**

1. As a User, I should be able to create a gender.
2. As a User, I should be able to get all items based on the gender.
3. As a user, I should be able to create an item from within a gender, automatically assigning the item to that specific gender.



**USER END POINTS**

|     Method    |   Endpoints                                   | Detail                           |
| ------------- | -----------------------------------           |--------------------------------- | 
|       GET     | api/categories/{categoryId}/items             | returns JSON all items           |
|       POST    | api/categories/{categoryId}/items             | creates new item                 |
|       GET     | api/categories/{categoryId}/items/{itemId}    | returns JSON for an item         |
|       PUT     | api/categories/{categoryId}/items/{itemId}    | update a item of specific category id         |
|       Delete  | api/categories/{categoryId}/items/{itemId}    | delete an item of a specific category         |
|       GET     | api/categories                                | returns JSON of all categories   |	
|       GET     | api/categories/{categoryId}                   | updates a specific category      |
|      POST     | api/categories/                               | creates new category             |
|      PUT      | api/categories/{categoryId}                   | updates specific category        |
|      DELETE   | api/categories/{categoryId}                   | deletes specific category        |
|      GET      | api/seasons/{seasonsId}/items                 | returns a season and items within|
|      POST     | api/seasons                                   | creates season                   |
|      POST     | api/seasons/{seasonsId}/items                 | creates an item with the specified season  |
| ------------- | -----------------------------------           |--------------------------------- |
|      POST     | api/gender/{genderId}/items                   | creates an item with the specified gender  |
|      GET      | api/gender/{genderId}/items                   | returns gender and items within  |
|      POST     | api/gender                                    | creates gender                   |
|      POST     | api/items                                     | creates an item                  |
|      GET      | api/items                                     | get all items                    |
|       PUT     | api/item/{itemID}                             | updates specific item            |
|      DELETE   | api/items/{itemID}                            | deletes specific item            |
******
****Technologies Used****
1. Java
2. Spring Framework (Data-Rest, Data-JPA, Test)
3. Postman
4. JUnit
5. Hamcrest
6. Git
