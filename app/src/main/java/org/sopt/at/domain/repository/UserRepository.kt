package org.sopt.at.domain.repository

import org.sopt.at.data.model.ResponseNicknameDto
import retrofit2.Response

interface UserRepository {
    suspend fun getUserNickname(userId: Long): Response<ResponseNicknameDto>
}