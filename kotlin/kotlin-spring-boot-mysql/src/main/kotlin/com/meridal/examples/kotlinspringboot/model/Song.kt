package com.meridal.examples.kotlinspringboot.model

import org.apache.commons.lang3.builder.ToStringBuilder
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="song")
class Song (
    var title: String,
    var duration: String,
    @Id @GeneratedValue
    var id: Long = 0L
    ) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Song

        if (id == 0L || id != other.id) return false

        return true
    }

    override fun hashCode(): Int = id.hashCode()

    override fun toString(): String = ToStringBuilder.reflectionToString(this)
}
