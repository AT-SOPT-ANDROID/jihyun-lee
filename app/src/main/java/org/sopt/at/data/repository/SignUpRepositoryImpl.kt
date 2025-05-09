package org.sopt.at.data.repository

import org.sopt.at.data.api.SignUpService
import org.sopt.at.data.model.RequestSignUpDto
import org.sopt.at.data.model.ResponseSignUpDto
import org.sopt.at.domain.repository.SignUpRepository
import retrofit2.Response
import javax.inject.Inject

class SignUpRepositoryImpl @Inject constructor(
    private val signUpService: SignUpService
) : SignUpRepository {
    override suspend fun signUp(request: RequestSignUpDto): Response<ResponseSignUpDto> {
        return signUpService.signup(request)
    }
}