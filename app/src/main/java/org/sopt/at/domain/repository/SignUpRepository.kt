package org.sopt.at.domain.repository

import org.sopt.at.data.model.RequestSignUpDto
import org.sopt.at.data.model.ResponseSignUpDto
import retrofit2.Response

interface SignUpRepository {
    suspend fun signUp(request: RequestSignUpDto): Response<ResponseSignUpDto>
}