package com.meridal.examples.domain

import java.io.Serializable
import java.util.*

class Song() : Serializable {

    var title: String? = null
    var duration: String? = null

    fun setDuration(mins: Int, secs: Int) {
        duration = formatTimePart(mins) + ":" + formatTimePart(secs)
    }

    private fun formatTimePart(timePart: Int): String {
        return String.format(Locale.UK, "%02d", timePart)
    }
}
