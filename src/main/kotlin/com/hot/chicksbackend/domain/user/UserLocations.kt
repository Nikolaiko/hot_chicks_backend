package com.hot.chicksbackend.domain.user

import com.fasterxml.jackson.annotation.JsonProperty
import com.hot.chicksbackend.db.USER_COLLECTION_NAME
import com.hot.chicksbackend.db.USER_LOCATIONS_COLLECTION_NAME
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = USER_LOCATIONS_COLLECTION_NAME)
data class UserLocations(
        @Id
        @JsonProperty("id")
        val id: String?,

        @Field(name = "location_id")
        @JsonProperty("locationId")
        val locationId: String,

        @Field(name = "user_id")
        @JsonProperty("userId")
        val userId: String
)