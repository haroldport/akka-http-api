package com.example.scala_http_api.module.video.infrastructure.stub

import com.example.scala_http_api.module.shared.stub.{IntStub, StringStub}
import com.example.scala_http_api.module.video.domain.VideoTitle

object VideoTitleStub {
  private val minimumChars = 1
  private val maximumChars = 50

  def apply(value: String): VideoTitle = VideoTitle(value)

  def random: VideoTitle = VideoTitle(
    StringStub.random(numChars = IntStub.randomBetween(minimumChars, maximumChars))
  )
}
