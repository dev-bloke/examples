import org.scalatest.diagrams._
import org.scalatest.funsuite._

class HelloWorldSpec extends AnyFunSuite with Diagrams {
  test("Hello should start with H") {
    assert("Hello World".startsWith("H"))
  }
}