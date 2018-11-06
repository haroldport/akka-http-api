package com.example.scala_http_api.module.user.infrastructure.marshaller

import spray.json.{DefaultJsonProtocol, RootJsonFormat}
import com.example.scala_http_api.module.shared.user.domain.UserId
import com.example.scala_http_api.module.shared.user.infrastructure.marshaller.UserIdJsonFormatMarshaller._
import com.example.scala_http_api.module.user.domain.{User, UserName}
import com.example.scala_http_api.module.user.infrastructure.marshaller.UserNameJsonFormatMarshaller._

object UserJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit val userFormat: RootJsonFormat[User] = jsonFormat2(User.apply(_: UserId, _: UserName))
}
