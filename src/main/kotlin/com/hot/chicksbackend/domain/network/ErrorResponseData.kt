package com.hot.chicksbackend.domain.network

import com.fasterxml.jackson.annotation.JsonProperty


data class ErrorResponseData(
        @JsonProperty("message")
        val message: String
)