package com.example.insta.ktorcompose.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.insta.ktorcompose.domain.entitiy.QouteEntity

@Database(
    entities = [QouteEntity::class],
    version = 1
)
abstract class MyDatabase : RoomDatabase(){
    abstract val dao: MyDao
}