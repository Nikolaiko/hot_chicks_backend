package com.hot.chicksbackend.domain.network

import com.fasterxml.jackson.annotation.JsonProperty

data class UserLoginData(
        @JsonProperty("name")
        val name: String,

        @JsonProperty("password")
        val password: String
)