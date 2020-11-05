package com.hot.chicksbackend.domain.common

data class OperationResult<T>(
    val message: String,
    val result: T?
)