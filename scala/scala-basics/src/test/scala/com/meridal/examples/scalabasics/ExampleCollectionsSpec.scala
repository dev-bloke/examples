package com.meridal.examples.scalabasics

import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleCollectionsSpec extends AnyFunSpec {

  val exampleCollections = new ExampleCollections()
  
  describe("An example of collections") {

    it ("should be created with a list with four integers") {
      val list: List[Int] = exampleCollections.list
      assert(list.length == 4)
    }

    it ("should be created with a map with two entries") {
      val map: Map[String, String] = exampleCollections.map
      assert(map.size == 2)
    }
  }
}
