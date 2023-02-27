package controllers

import akka.stream.Materializer
import com.google.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter
import sttp.tapir.server.play.{PlayServerInterpreter, PlayServerOptions}

import java.time.Instant
import javax.inject.Singleton
import scala.concurrent.{ExecutionContext, Future}

@Singleton
class TapirRouter @Inject()(implicit ec: ExecutionContext, mat: Materializer) extends SimpleRouter {

  val getTestServerEndpoint = TestEndpoints.getTestEndpoint.serverLogic {
    case (name: String) => Future.successful {
      if (name.isEmpty) {
        Left(TapirError(400, "name is blank"))
      } else {
        Right(s"Hello, $name")
      }
    }
  }

  val deleteTestServerEndpoint = TestEndpoints.deleteTestEndpoint.serverLogic {
    case (name: String) => Future.successful {
      if (name.isEmpty) {
        Left(TapirError(400, "name is blank"))
      } else {
        Right(s"Goodbye, $name")
      }
    }
  }

  private val interpreter = PlayServerInterpreter(PlayServerOptions.default)



  // Will throw exception in test
  def getTestRoute: Routes = interpreter.toRoutes(getTestServerEndpoint)
  def deleteTestRoute: Routes = interpreter.toRoutes(deleteTestServerEndpoint)
  override def routes: Routes = getTestRoute.orElse(deleteTestRoute)

  // Will pass the test
//  override def routes: Routes = interpreter.toRoutes(List(getTestServerEndpoint, deleteTestServerEndpoint))

}
