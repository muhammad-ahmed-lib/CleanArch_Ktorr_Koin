package com.example.insta.ktorcompose.domain.entitiy

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
@Entity(tableName = tableName)

data class QouteEntity(
    @PrimaryKey(autoGenerate = true)
    @SerialName("id")
    val id: Int = 0,

    @SerialName("name")
    val content: String = "",)

const val tableName = "StudentEntity"