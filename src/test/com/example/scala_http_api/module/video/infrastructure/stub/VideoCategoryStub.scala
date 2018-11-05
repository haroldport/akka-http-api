package com.example.scala_http_api.module.video.infrastructure.stub

import com.example.scala_http_api.module.shared.stub.IntStub
import com.example.scala_http_api.module.video.domain.VideoCategory

object VideoCategoryStub {
  private val categories = Seq("Screencast", "Interviews")

  def apply(value: String): VideoCategory = VideoCategory(value)

  def random: VideoCategory = VideoCategory(categories(IntStub.randomBetween(min = 0, max = categories.size - 1)))
}