package com.hot.chicksbackend.db.migrations.mongock

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate
import com.hot.chicksbackend.*
import com.hot.chicksbackend.db.*
import com.hot.chicksbackend.domain.locations.Location
import com.hot.chicksbackend.domain.locations.Mission
import com.mongodb.client.MongoDatabase
import java.util.*

@ChangeLog(order = "001")
class DbInitialization {

    @ChangeSet(order = "001", id = "create_collections", author = "master_nikolai")
    fun createCollections(database: MongoDatabase) {
        database.createCollection(USER_COLLECTION_NAME)
        database.createCollection(USER_RESOURCES_COLLECTION_NAME)
        database.createCollection(LOCATIONS_COLLECTION_NAME)
        database.createCollection(USER_LOCATIONS_COLLECTION_NAME)
        database.createCollection(MISSIONS_COLLECTION_NAME)
        database.createCollection(USER_MISSIONS_COLLECTION_NAME)
    }

    @ChangeSet(order = "002", id = "add_initial_values", author = "master_nikolai")
    fun createLocations(mongockTemplate: MongockTemplate) {
        val initialLocation = mongockTemplate.save(Location(UUID.randomUUID().toString(), INITIAL_LOCATION_NAME), LOCATIONS_COLLECTION_NAME)

        mongockTemplate.save(Mission(UUID.randomUUID().toString(),
                initialLocation.locationId!!,
                INITIAL_MISSION_1_NAME,
                ""
        ), MISSIONS_COLLECTION_NAME)

        mongockTemplate.save(Mission(UUID.randomUUID().toString(),
                initialLocation.locationId,
                INITIAL_MISSION_2_NAME,
                ""
        ), MISSIONS_COLLECTION_NAME)

        mongockTemplate.save(Mission(UUID.randomUUID().toString(),
                initialLocation.locationId,
                INITIAL_MISSION_3_NAME,
                ""
        ), MISSIONS_COLLECTION_NAME)

        mongockTemplate.save(Mission(UUID.randomUUID().toString(),
                initialLocation.locationId,
                INITIAL_MISSION_4_NAME,
                ""
        ), MISSIONS_COLLECTION_NAME)

        mongockTemplate.save(Mission(UUID.randomUUID().toString(),
                initialLocation.locationId,
                INITIAL_MISSION_5_NAME,
                ""
        ), MISSIONS_COLLECTION_NAME)

        mongockTemplate.save(Mission(UUID.randomUUID().toString(),
                initialLocation.locationId,
                INITIAL_MISSION_6_NAME,
                ""
        ), MISSIONS_COLLECTION_NAME)
    }
}