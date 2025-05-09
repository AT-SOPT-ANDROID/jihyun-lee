package org.sopt.at.data.api

import org.sopt.at.data.model.ResponseNicknameDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface UserService {
    @GET("/api/v1/users/me")
    suspend fun getUserNickname(
        @Header("userId") userId: Long
    ): Response<ResponseNicknameDto>
}