package com.meridal.examples.domain

import java.io.Serializable

data class Recording(val id: String) : Serializable {

    var artist: String? = null
    var catalogueNumber: String? = null
    var songs: MutableList<Song> = mutableListOf<Song>()
    var title: String? = null
    var year: Int? = null

    fun addSong(song: Song?) {
        songs.add(song!!)
    }

    fun addSongs(otherSongs: List<Song>) {
        songs.addAll(otherSongs)
    }
}
