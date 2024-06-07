package com.example.insta.ktorcompose.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insta.ktorcompose.abstraction.errorhandling.Result
import com.example.insta.ktorcompose.data.respository.RemoteRepository
import com.example.insta.ktorcompose.domain.model.Quote
import com.example.insta.ktorcompose.domain.usecase.RemoteUseCase
import com.example.insta.ktorcompose.domain.usecase.UseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class MainViewModel(private val useCase: RemoteUseCase) : ViewModel() {
    private val _quotesListMutableFlow: MutableStateFlow<Result<List<Quote>>> = MutableStateFlow(Result.InProgress(false))
    val quotesListStateFlow: StateFlow<Result<List<Quote>>> = _quotesListMutableFlow

    init {
        loadItems()
    }
    fun loadItems() {
       viewModelScope.launch {
           _quotesListMutableFlow.value=Result.InProgress(true)
           useCase.invoke(Unit).onSuccess {qouteResult->
               _quotesListMutableFlow.value=Result.InProgress(false)
               _quotesListMutableFlow.value=Result.Success(qouteResult.results)
           }.onFailure {
               _quotesListMutableFlow.value=Result.Failure(it.message.toString())
               _quotesListMutableFlow.value=Result.InProgress(false)
           }
       }
    }
}