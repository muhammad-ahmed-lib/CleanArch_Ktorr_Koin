package com.example.insta.ktorcompose.domain.usecase

interface UseCase<in Params, out Type> {
    suspend operator fun invoke(params: Params): Type
}
