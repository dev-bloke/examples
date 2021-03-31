package com.meridal.examples.kotlinspringboot.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "recordings")
@JsonIgnoreProperties(ignoreUnknown = true)
class Recording (
    var artist: String,
    var title: String,
    var catalogueNumber: String,
    var year: Int,
    var songs: MutableList<Song> = mutableListOf<Song>(),
    @Id
    var id: String?
    ) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recording

        if (id == null || id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
}
