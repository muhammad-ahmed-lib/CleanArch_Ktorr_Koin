package com.example.insta.ktorcompose.domain.repositoryimp

import com.example.insta.ktorcompose.data.respository.RemoteRepository
import com.example.insta.ktorcompose.domain.model.QuotesResults
import com.example.insta.ktorcompose.data.network.ApiService

import io.ktor.client.call.body
import io.ktor.util.InternalAPI


class RemoteRepositoryImpl(
    private val apiService: ApiService
) : RemoteRepository {
    @OptIn(InternalAPI::class)
    override suspend fun getQuotes(): Result<QuotesResults> {
        return try {
            kotlin.Result.success(apiService.getQuotes().body())
        } catch (e: Exception) {
            kotlin.Result.failure(e)
        }
    }
}