package com.hot.chicksbackend.domain.user

import com.fasterxml.jackson.annotation.JsonProperty
import com.hot.chicksbackend.db.MISSION_ID_FIELD_NAME
import com.hot.chicksbackend.db.MISSION_STATUS_FIELD_NAME
import com.hot.chicksbackend.db.USER_ID_FIELD_NAME
import com.hot.chicksbackend.db.USER_MISSIONS_COLLECTION_NAME
import com.hot.chicksbackend.domain.locations.MissionStatus
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field

@Document(collection = USER_MISSIONS_COLLECTION_NAME)
data class UserMissions(
        @Id
        @JsonProperty("id")
        val id: String?,

        @Field(name = MISSION_ID_FIELD_NAME)
        @JsonProperty("mission_id")
        val missionId: String?,

        @Field(name = USER_ID_FIELD_NAME)
        @JsonProperty("userId")
        val userId: String,

        @Field(name = MISSION_STATUS_FIELD_NAME)
        @JsonProperty(value = "status")
        val status: MissionStatus
)