package dev.alimansour.istore.daomain.usecase.product

import dev.alimansour.istore.daomain.model.Product
import dev.alimansour.istore.daomain.repository.ProductsRepository

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class GetCategoryProductsUseCase(private val repository: ProductsRepository) {
    fun execute(categoryId: Int): List<Product> = repository.getCategoryProducts(categoryId)
}