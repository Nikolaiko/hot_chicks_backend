package com.hot.chicksbackend.domain.user

import com.fasterxml.jackson.annotation.JsonProperty
import com.hot.chicksbackend.db.LOCATION_ID_FIELD_NAME
import com.hot.chicksbackend.db.USER_COLLECTION_NAME
import com.hot.chicksbackend.db.USER_ID_FIELD_NAME
import com.hot.chicksbackend.db.USER_LOCATIONS_COLLECTION_NAME
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = USER_LOCATIONS_COLLECTION_NAME)
data class UserLocations(
        @Id
        @JsonProperty("id")
        val id: String?,

        @Field(name = LOCATION_ID_FIELD_NAME)
        @JsonProperty("locationId")
        val locationId: String,

        @Field(name = USER_ID_FIELD_NAME)
        @JsonProperty("userId")
        val userId: String
)