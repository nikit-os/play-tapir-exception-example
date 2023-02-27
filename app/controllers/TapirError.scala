package controllers

import play.api.libs.json.Json

case class TapirError(errorCode: Int, message: String)
object TapirError {
  implicit val jsonFormat = Json.format[TapirError]
}
