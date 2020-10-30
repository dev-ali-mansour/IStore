package dev.alimansour.istore.daomain.usecase.order

import dev.alimansour.istore.daomain.model.Product
import dev.alimansour.istore.daomain.repository.OrderRepository

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class CreateOrderUseCase(private val repository: OrderRepository) {
    fun execute(userId: String, products: List<Product>, amount: Double): Boolean =
        repository.createOrder(userId, products, amount)
}