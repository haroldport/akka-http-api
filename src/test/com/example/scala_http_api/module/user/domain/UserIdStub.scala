package com.example.scala_http_api.module.user.domain

import java.util.UUID

import com.example.scala_http_api.module.shared.domain.UuidStub
import com.example.scala_http_api.module.shared.user.domain.UserId

object UserIdStub {

  def apply(value: String): UserId = UserIdStub(UuidStub(value))

  def apply(value: UUID): UserId = UserId(value)

  def random: UserId = UserId(UuidStub.random)

}
