package org.sopt.at.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.sopt.at.data.repository.SignInRepositoryImpl
import org.sopt.at.domain.repository.SignUpRepository
import org.sopt.at.data.repository.SignUpRepositoryImpl
import org.sopt.at.data.repository.UserRepositoryImpl
import org.sopt.at.domain.repository.SignInRepository
import org.sopt.at.domain.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindSignUpRepository(
        impl: SignUpRepositoryImpl
    ): SignUpRepository

    @Binds
    abstract fun bindSignInRepository(
        impl: SignInRepositoryImpl
    ): SignInRepository

    @Binds
    abstract fun bindUserRepository(
        impl: UserRepositoryImpl
    ): UserRepository

}