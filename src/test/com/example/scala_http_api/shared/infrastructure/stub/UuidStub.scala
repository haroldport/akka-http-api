package com.example.scala_http_api.shared.infrastructure.stub

import java.util.UUID

object UuidStub {

  def apply(value: String): UUID = UUID.fromString(value)

  def random: UUID = UUID.randomUUID()

}
