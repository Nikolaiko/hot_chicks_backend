package com.hot.chicksbackend.domain.locations

import com.fasterxml.jackson.annotation.JsonProperty
import com.hot.chicksbackend.db.*
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = MISSIONS_COLLECTION_NAME)
data class Mission(
        @Id
        @JsonProperty("id")
        val missionId: String?,

        @Field(name = LOCATION_ID_FIELD_NAME)
        @JsonProperty("locationId")
        val locationId: String,

        @Field(name = MISSION_NAME_FIELD_NAME)
        @JsonProperty("name")
        val missionName: String,

        @Field(name = MISSION_LAYOUT_FIELD_NAME)
        @JsonProperty("layout")
        val layout: String
)