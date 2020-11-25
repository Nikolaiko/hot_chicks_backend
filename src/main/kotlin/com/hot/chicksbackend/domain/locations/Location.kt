package com.hot.chicksbackend.domain.locations

import com.fasterxml.jackson.annotation.JsonProperty
import com.hot.chicksbackend.db.LOCATIONS_COLLECTION_NAME
import com.hot.chicksbackend.db.LOCATION_NAME_FIELD_NAME
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = LOCATIONS_COLLECTION_NAME)
data class Location(
        @Id
        @JsonProperty("id")
        val locationId: String?,

        @Field(name = LOCATION_NAME_FIELD_NAME)
        @JsonProperty("name")
        val locationName: String
)