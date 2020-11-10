package com.hot.chicksbackend.repositories.mongo

import com.hot.chicksbackend.domain.user.User
import com.hot.chicksbackend.repositories.UserRepository
import com.hot.chicksbackend.repositories.mongo.collections.MongoUserCollection
import kotlinx.coroutines.reactive.awaitFirstOrDefault
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Example
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class MongoUserRepository @Autowired constructor(
        private val collection: MongoUserCollection
) : UserRepository {

    override fun isUserExists(user: User) = collection.exists(Example.of(user))

    override fun addUser(user: User) = collection.insert(user)

    override fun getUserByNameAndPassword(name: String, password: String) =
            collection.getUserByNameAndPassword(name, password)


}