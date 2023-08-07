package com.meridal.examples.kotlinspringboot.model

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "recording")
class Recording (
    var artist: String,
    var title: String,
    var catalogueNumber: String,
    @Id @GeneratedValue
    var id: Long? = null
)
