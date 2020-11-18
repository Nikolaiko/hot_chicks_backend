package com.hot.chicksbackend.domain.user

import com.hot.chicksbackend.db.USER_COLLECTION_NAME
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "user_profiles")
data class UserProfile(
        @Id
        val id: String?,
        val deviceId:String,
        val userId: String,
        val updatedAt: Date
)