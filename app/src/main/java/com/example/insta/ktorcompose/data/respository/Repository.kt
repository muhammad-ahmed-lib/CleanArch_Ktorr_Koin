package com.example.insta.ktorcompose.data.respository

import com.example.insta.ktorcompose.domain.model.QuotesResults


interface RemoteRepository {
    suspend fun getQuotes(): kotlin.Result<QuotesResults>
}