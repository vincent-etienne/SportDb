package com.etienne.vincent.sportdb.data.remote.datasource

import com.etienne.vincent.sportdb.data.remote.SportsDbApi
import com.etienne.vincent.sportdb.data.remote.responses.GetAllTeamResponse
import com.etienne.vincent.sportdb.domain.entity.GenericStatus
import com.etienne.vincent.sportdb.domain.entity.GetAllLeagues
import com.etienne.vincent.sportdb.domain.entity.GetAllTeam
import com.etienne.vincent.sportdb.domain.repository.SportDbRepository
import io.mockk.*
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class RemoteDataSourceImplTest {

    private val sportsDbApi: SportsDbApi = mockk()

    private val classUnderTest = RemoteDataSourceImpl(sportsDbApi)

    @Before
    fun setUp() {
        clearAllMocks()
    }

    private fun <T> nullBodyResponse(): Response<T> = Response.success(null)
    private fun <T> genericErrorResponse(): Response<T> = Response.error(500, ResponseBody.create(null, ""))


    @Test
    fun `Get all team success`() {
        runBlocking {
            //GIVEN
            val leagueName = "French Ligue 1"
            coEvery { sportsDbApi.getAllTeam(leagueName) } returns Response.success(GetAllTeamResponse(arrayListOf()))

            val expectedResult = GetAllTeam(GenericStatus.SUCCESS, arrayListOf())

            //WHEN
            val result = classUnderTest.getAllTeam(leagueName)

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportsDbApi.getAllTeam(leagueName)
            }
            confirmVerified(sportsDbApi)
        }
    }

    @Test
    fun `Get all team error`() {
        runBlocking {
            //GIVEN
            val leagueName = "French Ligue 1"
            coEvery { sportsDbApi.getAllTeam(leagueName) } returns genericErrorResponse()

            val expectedResult = GetAllTeam.ERROR

            //WHEN
            val result = classUnderTest.getAllTeam(leagueName)

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportsDbApi.getAllTeam(leagueName)
            }
            confirmVerified(sportsDbApi)
        }
    }

    @Test
    fun `Get all team empty body`() {
        runBlocking {
            //GIVEN
            val leagueName = "French Ligue 1"
            coEvery { sportsDbApi.getAllTeam(leagueName) } returns nullBodyResponse()

            val expectedResult = GetAllTeam.ERROR

            //WHEN
            val result = classUnderTest.getAllTeam(leagueName)

            //THEN
            assertEquals(expectedResult, result)
            coVerify(exactly = 1) {
                sportsDbApi.getAllTeam(leagueName)
            }
            confirmVerified(sportsDbApi)
        }
    }
}