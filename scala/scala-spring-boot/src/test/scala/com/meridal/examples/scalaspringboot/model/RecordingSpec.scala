package com.meridal.examples.scalaspringboot.model

import org.scalatest.funspec.AnyFunSpec
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RecordingSpec extends AnyFunSpec {

    val ID = 1234L
    val OTHER_ID = 5678L
    val ARTIST = "Sigur Ros"
    val TITLE = "Takk.."
    val CAT_NO = "SR3"

    val RECORDING = new Recording(ARTIST, TITLE, CAT_NO)
    val OTHER = new Recording(ARTIST, TITLE, CAT_NO)

    describe ("A recording") {
        
        it ("should be equal to another recording when the IDs are the same") {
            RECORDING.id = ID
            OTHER.id = ID
            assert(RECORDING == OTHER)
            assert(RECORDING.hashCode == OTHER.hashCode)
        }

        it ("should not be equal to another recording when the IDs are different") {
            RECORDING.id = ID
            OTHER.id = OTHER_ID
            assert(RECORDING != OTHER)
            assert(RECORDING.hashCode != OTHER.hashCode)
        }

        it ("should not be equal to another type of object") {
            RECORDING.id = ID
            val list = List(1, 2, 3)
            assert(RECORDING != list)
            assert(RECORDING.hashCode != list.hashCode)
        }

        it ("should not be equal to null") {
            RECORDING.id = ID
            val other = null
            assert(RECORDING != other)
        }
    }
  
}
