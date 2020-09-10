package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.entity.GenericStatus
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllLeaguesUseCaseTest {

    private val sportDbRepository: SportDbRepository = mockk()

    private val classUnderTest = GetAllLeaguesUseCase(sportDbRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `Get all leagues success`() {
        runBlocking {
            //GIVEN
            val expectedResult = GetAllLeagues(GenericStatus.SUCCESS, arrayListOf())
            coEvery { sportDbRepository.getAllLeagues() } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke()

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportDbRepository.getAllLeagues()
            }
            confirmVerified(sportDbRepository)
        }
    }

    @Test
    fun `Get all leagues error`() {
        runBlocking {
            //GIVEN
            val expectedResult = GetAllLeagues(GenericStatus.ERROR, arrayListOf())
            coEvery { sportDbRepository.getAllLeagues() } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke()

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportDbRepository.getAllLeagues()
            }
            confirmVerified(sportDbRepository)
        }
    }
}