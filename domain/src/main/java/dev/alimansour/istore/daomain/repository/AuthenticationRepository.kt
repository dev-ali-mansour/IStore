package dev.alimansour.istore.daomain.repository

/**
 * IStore Android Application developed by: Ali Mansour
 * Copyright © 2020 Ali Mansour. All Rights Reserved.
 * This file may not be redistributed in whole or significant part.
 * ----------------- IStore IS FREE SOFTWARE ------------------
 * https://www.alimansour.dev   |   dev.ali.mansour@gmail.com
 */
interface AuthenticationRepository {

    /**
     * Sign up a new user using his email address
     * @param fullName User full name
     * @param email user email address
     * @param password user password
     * @return User sign up process result
     */
    fun signUp(fullName: String, email: String, password: String): Boolean

    /**
     * Sign in user using his email address and password
     * @param email user email address
     * @param password user password
     * @return User sign in process result
     */
    fun signIn(email: String, password: String): Boolean

    /**
     * Reset user password using his email address
     * @param email User email address
     * @return User reset password process result
     */
    fun resetPassword(email: String): Boolean
}