package com.example.insta.ktorcompose.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.insta.ktorcompose.domain.entitiy.QouteEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(studentEntity: QouteEntity)

    @Delete
    suspend fun delete(studentEntity: QouteEntity)

    @Update
    suspend fun update(studentEntity: QouteEntity)

    @Query("SELECT * FROM studententity")
    fun getAllStudents(): Flow<List<QouteEntity>>
}