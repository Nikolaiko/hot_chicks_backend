package com.hot.chicksbackend.repositories

import com.hot.chicksbackend.domain.user.UserResources
import reactor.core.publisher.Mono

interface ResourcesRepository {
    fun initUserResources(resources: UserResources): Mono<UserResources>
}