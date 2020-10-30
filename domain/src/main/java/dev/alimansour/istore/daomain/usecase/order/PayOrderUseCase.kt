package dev.alimansour.istore.daomain.usecase.order

import dev.alimansour.istore.daomain.repository.OrderRepository

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
class PayOrderUseCase(private val repository: OrderRepository) {
    fun execute(orderId: Int): Boolean = repository.payOrder(orderId)
}