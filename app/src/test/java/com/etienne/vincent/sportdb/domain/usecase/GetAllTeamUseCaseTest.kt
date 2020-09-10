package com.etienne.vincent.sportdb.domain.usecase

import com.etienne.vincent.sportdb.domain.entity.GenericStatus
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAllTeamUseCaseTest {

    private val sportDbRepository: SportDbRepository = mockk()

    private val classUnderTest = GetAllTeamUseCase(sportDbRepository)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    @Test
    fun `Get all team success`() {
        runBlocking {
            //GIVEN
            val leagueName = "French Ligue 1"
            val expectedResult = GetAllTeam(GenericStatus.SUCCESS, arrayListOf())
            coEvery { sportDbRepository.getAllTeam(leagueName) } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke(leagueName)

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportDbRepository.getAllTeam(leagueName)
            }
            confirmVerified(sportDbRepository)
        }
    }

    @Test
    fun `Get all team error`() {
        runBlocking {
            //GIVEN
            val leagueName = "French Ligue 1"
            val expectedResult = GetAllTeam(GenericStatus.ERROR, arrayListOf())
            coEvery { sportDbRepository.getAllTeam(leagueName) } returns expectedResult

            //WHEN
            val result = classUnderTest.invoke(leagueName)

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportDbRepository.getAllTeam(leagueName)
            }
            confirmVerified(sportDbRepository)
        }
    }
}