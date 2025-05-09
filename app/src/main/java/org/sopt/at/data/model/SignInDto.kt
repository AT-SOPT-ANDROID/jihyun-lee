package org.sopt.at.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RequestSignInDto(
    val loginId: String,
    val password: String,
)

@Serializable
data class ResponseSignInDataDto(
    val userId: Long,
)

@Serializable
data class ResponseSignInDto(
    val success: Boolean,
    val code: String,
    val message: String,
    val data: ResponseSignInDataDto
)