package dev.alimansour.istore.daomain.repository

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface CartRepository {

    fun addToCart(userId: String, productId: Int): Boolean

    fun removeFromCart(userId: String, productId: Int): Boolean

    fun updateQuantity(userId: String, productId: Int, quantity: Int): Boolean

}