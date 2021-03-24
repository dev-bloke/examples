package com.meridal.examples.kotlinspringboot.model

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "recording")
class Recording (
    var artist: String,
    var title: String,
    var catalogueNumber: String,
    var year: Int,
    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "recording_id")
    var songs: MutableList<Song> = mutableListOf<Song>(),
    @Id @GeneratedValue
    var id: Long = 0L
    ) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Recording

        if (id == 0L || id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()
}
