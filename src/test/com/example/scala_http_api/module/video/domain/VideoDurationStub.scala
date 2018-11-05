package com.example.scala_http_api.module.video.domain

import scala.concurrent.duration.Duration

import com.example.scala_http_api.module.shared.domain.DurationStub

object VideoDurationStub {
  def apply(value: Duration): VideoDuration = VideoDuration(value)

  def random: VideoDuration = VideoDuration(DurationStub.random)
}
