package com.hot.chicksbackend.repositories

import com.hot.chicksbackend.domain.user.UserMissions
import reactor.core.publisher.Mono

interface MissionRepository {
    fun addUserMission(mission: UserMissions): Mono<UserMissions>
}