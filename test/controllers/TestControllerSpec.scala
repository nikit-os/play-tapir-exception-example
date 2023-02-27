
package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.mvc.Result
import play.api.test.Helpers._
import play.api.test._
import sttp.tapir.testing.EndpointVerifier

import scala.concurrent.Future

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class TestControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "TestController" should {

    "not throw exception" in {
      val res = EndpointVerifier(List(TestEndpoints.getTestEndpoint, TestEndpoints.deleteTestEndpoint))
      println(s"EndpointVerifier: $res")

      val getHttpRequest = FakeRequest(GET, s"/test/some-name")
      val getFuture: Future[Result] = route(app, getHttpRequest).get
      val getResp = contentAsString(getFuture)
      println(s"GET response: $getResp")

      val deleteHttpRequest = FakeRequest(DELETE, s"/test/some-name")
      val deleteFuture: Future[Result] = route(app, deleteHttpRequest).get
      val deleteResp = contentAsString(deleteFuture)
      println(s"DELETE response: $deleteResp")
    }
  }
}
