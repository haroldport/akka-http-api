package com.example.scala_http_api.entry_point.controller.video

import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import com.example.scala_http_api.module.video.application.search.VideosSearcher
import com.example.scala_http_api.module.video.infrastructure.marshaller.VideoJsonFormatMarshaller._
import spray.json.DefaultJsonProtocol

final class VideoGetController(searcher: VideosSearcher) extends SprayJsonSupport with DefaultJsonProtocol {
  def get(): StandardRoute = complete(searcher.all())
}
