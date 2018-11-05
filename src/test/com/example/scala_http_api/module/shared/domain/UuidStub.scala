package com.example.scala_http_api.module.shared.domain

import java.util.UUID

object UuidStub {

  def apply(value: String): UUID = UUID.fromString(value)

  def random: UUID = UUID.randomUUID()

}
