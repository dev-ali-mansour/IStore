package dev.alimansour.istore.daomain.usecase.cart

import dev.alimansour.istore.daomain.repository.CartRepository

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class AddToCartUseCase(private val repository: CartRepository) {
    fun execute(userId: String, productId: Int): Boolean = repository.addToCart(userId, productId)
}