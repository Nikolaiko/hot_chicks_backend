package com.hot.chicksbackend.services

import com.hot.chicksbackend.ERROR_ADDING_USER
import com.hot.chicksbackend.INITIAL_LOCATION_NAME
import com.hot.chicksbackend.TOKENS_INITIAL_VALUE
import com.hot.chicksbackend.USER_ALREADY_EXISTS
import com.hot.chicksbackend.domain.common.OperationResult
import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.domain.user.UserLocations
import com.hot.chicksbackend.domain.user.UserProfile
import com.hot.chicksbackend.domain.user.UserResources
import com.hot.chicksbackend.repositories.LocationRepository
import com.hot.chicksbackend.repositories.ResourcesRepository
import com.hot.chicksbackend.repositories.UserRepository
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.query
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Service
import reactor.kotlin.core.publisher.switchIfEmpty
import reactor.kotlin.core.publisher.toMono
import java.time.Instant
import java.util.*

@Service
class UserService @Autowired constructor(
        private val userRepository: UserRepository,
        private val locationRepository: LocationRepository,
        private val resourcesRepository: ResourcesRepository,
        private val template: ReactiveMongoTemplate
) {
    suspend fun loginUser(name: String, password: String) = coroutineScope<User?> {
        userRepository.getUserByNameAndPassword(name, password).awaitFirstOrNull()
    }

    suspend fun registerUser(name: String, password: String) = coroutineScope<OperationResult<User>> {
        println(template.mongoDatabase.awaitFirst().name)
        val randomGuid = UUID.randomUUID().toString()
        val dt1 = Date()
        println(template.insert(UserProfile(null, "1234", randomGuid, dt1), "user_profiles").awaitFirst())

        println(dt1)

        Thread.sleep(3000)

        val dt2 = Date()

        println(dt2)

        template.findOne(
                Query(Criteria.where("userId").isEqualTo(randomGuid).and("updatedAt").gt(dt2)),
                UserProfile::class.java
        ).
        switchIfEmpty {
            println("Empty!!!")
            UserProfile(null, "Default", "Default", Date()).toMono()
        }.awaitFirst()



        OperationResult<User>(USER_ALREADY_EXISTS, null)
//        val existingUser = userRepository.getUserByNameAndPassword(name, password).awaitFirstOrNull()
//        when(existingUser) {
//            null -> {
//                val insertedUser = userRepository.addUser(User(null, name, password)).awaitFirstOrNull()
//                if (insertedUser == null) {
//                    OperationResult<User>(ERROR_ADDING_USER, null)
//                } else {
//                    val startUpLocation = locationRepository.getLocationByName(INITIAL_LOCATION_NAME).awaitFirstOrNull()
//                    val userLocations = UserLocations(null, startUpLocation?.locationId!!, insertedUser.userId!!)
//                    val resources = UserResources(null, TOKENS_INITIAL_VALUE, insertedUser.userId)
//
//                    OperationResult<User>("OK", insertedUser)
//                }
//            }
//            else -> {
//                OperationResult<User>(USER_ALREADY_EXISTS, null)
//            }
//        }


    }
}