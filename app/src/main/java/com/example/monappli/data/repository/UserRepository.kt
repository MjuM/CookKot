package com.example.monappli.data.repository

import com.example.monappli.data.repository.local.models.DatabaseDao
import com.example.monappli.data.repository.local.models.toData
import com.example.monappli.data.repository.local.models.toEntity
import com.example.monappli.domain.usecase.entity.User

class UserRepository(
    private val databaseDao: DatabaseDao
    ) {

    suspend fun createUser(user: User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User? {
        val userLocal = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}