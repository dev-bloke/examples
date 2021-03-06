package com.meridal.examples.kotlinspringboot.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable

@DynamoDBTable(tableName = "recordings")
class Recording {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    var id: String? = null

    @DynamoDBAttribute var artist: String? = null
    @DynamoDBAttribute var title: String? = null
    @DynamoDBAttribute var catalogueNumber: String? = null
    @DynamoDBAttribute var year: Int? = null
    @DynamoDBAttribute var songs: MutableList<Song> = mutableListOf<Song>()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recording

        if (id == null || id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
}
