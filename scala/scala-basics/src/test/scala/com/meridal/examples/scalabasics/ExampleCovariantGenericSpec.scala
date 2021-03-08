package com.meridal.examples.scalabasics
import org.scalatest.funspec.AnyFunSpec
import org.scalatestplus.junit.JUnitRunner
import scala.collection.mutable.Stack
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ExampleCovariantGenericSpec extends AnyFunSpec {
  describe ("a covariant generic example") {
    
    it ("can contain a cat") {
        var cat = new Cat("Barney")
        var covariant: ExampleCovariantGeneric[Animal] = new ExampleCovariantGeneric[Cat](cat)
        assert(covariant.contained.name == "Barney")
    }

    it ("can contain a dog") {
        var dog = new Dog("Patch")
        var covariant: ExampleCovariantGeneric[Animal] = new ExampleCovariantGeneric[Dog](dog)
        assert(covariant.contained.name == "Patch")
    }
  }
}
