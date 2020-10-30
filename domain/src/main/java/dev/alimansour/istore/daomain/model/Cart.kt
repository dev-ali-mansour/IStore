package dev.alimansour.istore.daomain.model

import java.util.*

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
data class Cart(
    private val id: Int,
    private val date: Date,
    private val userId: String,
    private val products: List<Product>,
    private val amount: Double
)