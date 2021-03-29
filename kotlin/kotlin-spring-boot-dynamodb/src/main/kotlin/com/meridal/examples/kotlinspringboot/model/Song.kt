package com.meridal.examples.kotlinspringboot.model

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument

@DynamoDBDocument
class Song {
    @DynamoDBAttribute var title: String? = null
    @DynamoDBAttribute var duration: String? = null
}

