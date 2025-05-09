package org.sopt.at.data.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponseNicknameDataDto(
    val nickname: String
)

@Serializable
data class ResponseNicknameDto(
    val success: Boolean,
    val code: String,
    val message: String,
    val data: ResponseNicknameDataDto
)