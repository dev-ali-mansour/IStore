package dev.alimansour.istore.daomain.model

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
data class Product(
    private val id: Int,
    private val title: String,
    private val categoryId: Int,
    private val description: String,
    private val image: String,
    private val price: Double,
    private val quantity: Int
)