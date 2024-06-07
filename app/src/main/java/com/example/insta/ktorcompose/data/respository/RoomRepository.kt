package com.example.insta.ktorcompose.data.respository

import com.example.insta.ktorcompose.domain.entitiy.QouteEntity
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    suspend fun insert(studentEntity: QouteEntity)

    suspend fun delete(studentEntity: QouteEntity)

    suspend fun update(studentEntity: QouteEntity)

    suspend fun getAllStudents(): Flow<List<QouteEntity>>
}