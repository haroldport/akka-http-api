package com.example.scala_http_api.entry_point.controller.video

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.StandardRoute
import com.example.scala_http_api.module.shared.user.domain.UserId
import com.example.scala_http_api.module.video.application.create.VideoCreator
import com.example.scala_http_api.module.video.domain.{VideoCategory, VideoDuration, VideoId, VideoTitle}

import scala.concurrent.duration.Duration

final class VideoPostController(creator: VideoCreator) {
  def post(id: String, title: String, duration: Duration, category: String, creatorId: String): StandardRoute = {
    creator.create(VideoId(id), VideoTitle(title), VideoDuration(duration), VideoCategory(category), UserId(creatorId))

    complete(HttpResponse(NoContent))
  }
}
