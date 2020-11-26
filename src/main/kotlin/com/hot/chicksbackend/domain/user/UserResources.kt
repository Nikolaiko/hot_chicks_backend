package com.hot.chicksbackend.domain.user

import com.fasterxml.jackson.annotation.JsonProperty
import com.hot.chicksbackend.db.USER_ID_FIELD_NAME
import com.hot.chicksbackend.db.USER_RESOURCES_COLLECTION_NAME
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = USER_RESOURCES_COLLECTION_NAME)
data class UserResources(
        @Id
        @JsonProperty("id")
        val id: String?,

        @Field(name = "tokens")
        @JsonProperty("tokens")
        val tokens: String,

        @Field(name = USER_ID_FIELD_NAME)
        @JsonProperty("userId")
        val userId: String
)