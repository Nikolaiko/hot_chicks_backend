package com.hot.chicksbackend.services

import com.hot.chicksbackend.ERROR_ADDING_USER
import com.hot.chicksbackend.USER_ALREADY_EXISTS
import com.hot.chicksbackend.domain.common.OperationResult
import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.repositories.UserRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(
        private val userRepository: UserRepository
) {
    suspend fun loginUser(name: String, password: String) = coroutineScope<User?> {
        userRepository.getUserByNameAndPassword(name, password).awaitFirstOrNull()
    }

    suspend fun registerUser(name: String, password: String) = coroutineScope<OperationResult<User>> {
        val existingUser = userRepository.getUserByNameAndPassword(name, password).awaitFirstOrNull()
        when(existingUser) {
            null -> {
                val insertedUser = userRepository.insert(User(null, name, password)).awaitFirstOrNull()
                if (insertedUser == null) {
                    OperationResult<User>(
                            ERROR_ADDING_USER,
                            null
                    )
                } else {
                    OperationResult<User>(
                            "OK",
                            insertedUser
                    )
                }
            }
            else -> {
                OperationResult<User>(
                        USER_ALREADY_EXISTS,
                        null
                )
            }
        }
    }
}