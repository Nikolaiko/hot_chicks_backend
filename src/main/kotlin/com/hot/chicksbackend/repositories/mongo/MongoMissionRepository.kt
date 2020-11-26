package com.hot.chicksbackend.repositories.mongo

import com.hot.chicksbackend.domain.user.UserMissions
import com.hot.chicksbackend.repositories.MissionRepository
import com.hot.chicksbackend.repositories.mongo.collections.MongoUserMissionCollection
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
class MongoMissionRepository @Autowired constructor(
        private val missionCollection: MongoUserMissionCollection
) : MissionRepository {

    override fun addUserMission(mission: UserMissions): Mono<UserMissions> = missionCollection.insert(mission)
}