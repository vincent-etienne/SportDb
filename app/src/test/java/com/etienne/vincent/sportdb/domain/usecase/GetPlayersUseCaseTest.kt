package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.entity.GenericStatus
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetPlayers
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetPlayersUseCaseTest {

    private val sportDbRepository: SportDbRepository = mockk()

    private val classUnderTest = GetPlayersUseCase(sportDbRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `Get players success`() {
        runBlocking {
            //GIVEN
            val teamName = "Paris SG"
            val expectedResult = GetPlayers(GenericStatus.SUCCESS, arrayListOf())
            coEvery { sportDbRepository.getPlayers(teamName) } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke(teamName)

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportDbRepository.getPlayers(teamName)
            }
            confirmVerified(sportDbRepository)
        }
    }

    @Test
    fun `Get players error`() {
        runBlocking {
            //GIVEN
            val teamName = "Paris SG"
            val expectedResult = GetPlayers(GenericStatus.ERROR, arrayListOf())
            coEvery { sportDbRepository.getPlayers(teamName) } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke(teamName)

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportDbRepository.getPlayers(teamName)
            }
            confirmVerified(sportDbRepository)
        }
    }
}