package com.example.monappli.domain.usecase

import com.example.monappli.data.repository.UserRepository
import com.example.monappli.domain.usecase.entity.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`() {
        runBlocking {
            val email = ""
            coEvery { userRepository.getUser(email) } returns null

          val result = classUnderTest.invoke(email)

            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, null)
        }
        }


    @Test
    fun `invoke with valid email`() {
        runBlocking {
            val email = "a@a.c"
            val expecteddUser = User("a@a.c")
            coEvery { userRepository.getUser(email) } returns expecteddUser

            val result = classUnderTest.invoke(email)

            coVerify(exactly = 1) { userRepository.getUser(email) }
            assertEquals(result, expecteddUser)
        }
    }
    }