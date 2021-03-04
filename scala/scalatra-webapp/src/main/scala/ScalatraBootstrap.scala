import com.meridal.examples.scalatra._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext): Unit = {
    context.mount(new ExampleScalatraServlet, "/*")
  }
}
