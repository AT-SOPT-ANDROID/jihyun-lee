package org.sopt.at.data.repository

import org.sopt.at.data.api.UserService
import org.sopt.at.data.model.ResponseNicknameDto
import org.sopt.at.domain.repository.UserRepository
import retrofit2.Response
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userService: UserService
) : UserRepository {
    override suspend fun getUserNickname(userId: Long): Response<ResponseNicknameDto> {
        return userService.getUserNickname(userId)
    }
}