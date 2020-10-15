package dev.alimansour.istore.daomain.repository

import dev.alimansour.istore.daomain.model.Category
import dev.alimansour.istore.daomain.model.Product

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface ProductsRepository {

    /**
     * Get list of product categories
     * @return List of categories
     */
    fun getCategories(): List<Category>

    /**
     * Get List of products for a specific category by it's id
     * @param categoryId Category Id
     * @return List of products
     */
    fun getCategoryProducts(categoryId: Int): List<Product>

    /**
     * Get list of latest count of listed products
     * @param count the number of latest products to be listed
     * @return List of products
     */
    fun getLatestProducts(count: Int): List<Product>
}