package org.sopt.at.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RequestSignUpDto(
    val loginId: String,
    val password: String,
    val nickname: String
)

@Serializable
data class ResponseSignUpDataDto(
    val userId: Int,
    val nickname: String
)

@Serializable
data class ResponseSignUpDto(
    val success: Boolean,
    val code: String,
    val message: String,
    val data: ResponseSignUpDataDto
)