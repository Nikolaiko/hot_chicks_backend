package com.hot.chicksbackend.repositories.mongo

import com.hot.chicksbackend.domain.user.UserResources
import com.hot.chicksbackend.repositories.ResourcesRepository
import com.hot.chicksbackend.repositories.mongo.collections.MongoUserResourcesCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class MongoResourcesRepository @Autowired constructor(
        private val resourcesCollection: MongoUserResourcesCollection
) : ResourcesRepository {

    override fun initUserResources(resources: UserResources) = resourcesCollection.insert(resources)

}