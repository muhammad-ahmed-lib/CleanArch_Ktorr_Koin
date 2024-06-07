package com.example.insta.ktorcompose.domain.usecase

import com.example.insta.ktorcompose.data.respository.RemoteRepository
import com.example.insta.ktorcompose.domain.model.QuotesResults

class RemoteUseCase (private val rep: RemoteRepository): UseCase<Unit, Result<QuotesResults>> {
    override suspend fun invoke(params: Unit): Result<QuotesResults> {
        return rep.getQuotes()
    }
}