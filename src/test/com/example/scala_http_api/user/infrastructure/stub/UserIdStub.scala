package com.example.scala_http_api.user.infrastructure.stub

import java.util.UUID

import com.example.scala_http_api.shared.infrastructure.stub.UuidStub
import com.example.scala_http_api.user.domain.UserId

object UserIdStub {

  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)

}