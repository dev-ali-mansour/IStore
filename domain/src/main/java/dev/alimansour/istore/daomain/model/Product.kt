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
     val title: String,
     private val categoryId: Int,
      val description: String,
    val image: String,
    val price: Double,
    private val quantity: Int
)