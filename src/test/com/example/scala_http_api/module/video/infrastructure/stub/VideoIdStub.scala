package com.example.scala_http_api.module.video.infrastructure.stub

import java.util.UUID

import com.example.scala_http_api.module.shared.stub.UuidStub
import com.example.scala_http_api.module.user.domain.UserId
import com.example.scala_http_api.module.video.domain.VideoId

object VideoIdStub {
  def apply(value: String): VideoId = VideoIdStub(UuidStub(value))

  def apply(value: UUID): VideoId = VideoId(value)

  def random: UserId = UserId(UuidStub.random)
}
