package com.example.monappli.domain.usecase

import com.example.monappli.data.repository.UserRepository
import com.example.monappli.domain.usecase.entity.User

class GetUserUseCase(
    private val userRepository: UserRepository
) {
    suspend fun invoke(email: String) : User? {
        return userRepository.getUser(email)

    }
}