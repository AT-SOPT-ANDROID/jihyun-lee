package org.sopt.at.data.api

import org.sopt.at.data.model.RequestSignUpDto
import org.sopt.at.data.model.ResponseSignUpDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("/api/v1/auth/signup")
    suspend fun signup(
        @Body request: RequestSignUpDto
    ): Response<ResponseSignUpDto> // 또는 Response<SignupResponse> 형태로
}