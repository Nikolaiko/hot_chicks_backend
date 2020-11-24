package com.hot.chicksbackend.db.migrations.mongock

import com.github.cloudyrock.mongock.ChangeLog
import com.github.cloudyrock.mongock.ChangeSet
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate
import com.hot.chicksbackend.INITIAL_LOCATION_NAME
import com.hot.chicksbackend.db.LOCATIONS_COLLECTION_NAME
import com.hot.chicksbackend.db.USER_COLLECTION_NAME
import com.hot.chicksbackend.db.USER_LOCATIONS_COLLECTION_NAME
import com.hot.chicksbackend.db.USER_RESOURCES_COLLECTION_NAME
import com.hot.chicksbackend.domain.locations.Location
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
    }

    @ChangeSet(order = "002", id = "add_initial_values", author = "master_nikolai")
    fun createLocations(mongockTemplate: MongockTemplate) {
        mongockTemplate.save(Location(UUID.randomUUID().toString(), INITIAL_LOCATION_NAME), LOCATIONS_COLLECTION_NAME)
    }
}