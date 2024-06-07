package com.example.insta.ktorcompose.domain.repositoryimp

import androidx.room.Room
import com.example.insta.ktorcompose.data.database.MyDao
import com.example.insta.ktorcompose.data.respository.RemoteRepository
import com.example.insta.ktorcompose.data.respository.RoomRepository
import com.example.insta.ktorcompose.domain.entitiy.QouteEntity
import com.example.insta.ktorcompose.domain.model.QuotesResults
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class RoomRepositoryImp( private val dao: MyDao): RoomRepository {
    override suspend fun insert(studentEntity: QouteEntity) {
        withContext(IO) {
            dao.insert(studentEntity)
        }
    }

    override suspend fun delete(studentEntity: QouteEntity) {
        withContext(IO) {
            dao.delete(studentEntity)
        }
    }

    override suspend fun update(studentEntity: QouteEntity) {
        withContext(IO) {
            dao.update(studentEntity)
        }
    }

    override suspend fun getAllStudents(): Flow<List<QouteEntity>> {
        return withContext(IO) {
            dao.getAllStudents()
        }
    }

}