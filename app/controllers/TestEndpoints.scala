package controllers

import sttp.tapir._
import sttp.tapir.generic.auto._
import sttp.tapir.json.play._
import sttp.model.StatusCode

object TestEndpoints {

  val getTestEndpoint: PublicEndpoint[String, TapirError, String, Any] =
    endpoint
      .get
      .in("test" / path[String]("name"))
      .out(stringBody)
      .errorOut(jsonBody[TapirError] and statusCode(StatusCode.BadRequest))

  val deleteTestEndpoint: PublicEndpoint[String, TapirError, String, Any] =
    endpoint
      .delete
      .in("test" / path[String]("name"))
      .out(stringBody)
      .errorOut(jsonBody[TapirError] and statusCode(StatusCode.BadRequest))

}
