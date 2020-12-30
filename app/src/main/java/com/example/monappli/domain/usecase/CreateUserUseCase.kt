package com.example.monappli.domain.usecase

import com.example.monappli.data.repository.UserRepository
import com.example.monappli.domain.usecase.entity.User

class CreateUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(user: User){
        userRepository.createUser(user)
    }
}