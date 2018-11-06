package com.example.scala_http_api.module.shared.user.infrastructure.marshaller

import java.util.UUID

import spray.json.{DefaultJsonProtocol, JsValue, JsonFormat, _}
import com.example.scala_http_api.module.shared.marshaller.infrastructure.UuidJsonFormatMarshaller._
import com.example.scala_http_api.module.shared.user.domain.UserId

object UserIdJsonFormatMarshaller extends DefaultJsonProtocol {
  implicit object UserIdMarshaller extends JsonFormat[UserId] {
    override def write(value: UserId): JsValue = value.value.toJson

    override def read(value: JsValue): UserId = UserId(value.convertTo[UUID])
  }
}
