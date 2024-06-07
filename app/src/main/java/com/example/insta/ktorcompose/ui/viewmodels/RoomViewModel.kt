package com.example.insta.ktorcompose.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.insta.ktorcompose.data.respository.RoomRepository
import com.example.insta.ktorcompose.domain.entitiy.QouteEntity
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RoomViewModel(private val repository: RoomRepository):ViewModel() {
    val coroutineExp= CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.d("coroutineExp", "coroutineExp$throwable ")
    }

    private val _qouteList = MutableStateFlow(emptyList<QouteEntity>())
    val observeQuote: StateFlow<List<QouteEntity>> = _qouteList

    init {
        getAllQuotes()
    }
    fun getAllQuotes() {
        val coroutineExp= CoroutineExceptionHandler { coroutineContext, throwable ->  }
        viewModelScope.launch(IO+coroutineExp) {
            repository.getAllStudents().collectLatest {
                _qouteList.tryEmit(it)
            }
        }
    }

    fun updateQuote(studentEntity: QouteEntity) {
        viewModelScope.launch(IO+coroutineExp) {
            repository.update(studentEntity)
        }
    }

    fun insertStudent(studentEntity: QouteEntity) {
        viewModelScope.launch(IO+coroutineExp) {
            repository.insert(studentEntity)
        }
    }


    private val _studentName = MutableStateFlow("")
    val studentName = _studentName.asStateFlow()
    fun setStudentName(name: String) {
        _studentName.tryEmit(name)
    }



    private val _studentRollNo = MutableStateFlow("")
    val studentRollNo = _studentRollNo.asStateFlow()
    fun setStudentRollNo(roll: String) {
        _studentRollNo.tryEmit(roll)
    }



    private val _isChecked = MutableStateFlow(false)
    val isChecked = _isChecked.asStateFlow()
    fun setChecked(bool: Boolean) {
        _isChecked.tryEmit(bool)
    }
}