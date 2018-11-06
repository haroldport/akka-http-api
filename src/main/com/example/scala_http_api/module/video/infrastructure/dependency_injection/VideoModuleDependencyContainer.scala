package com.example.scala_http_api.module.video.infrastructure.dependency_injection

import com.example.scala_http_api.module.shared.bus.domain.MessagePublisher
import com.example.scala_http_api.module.shared.persistence.infrastructure.doobie.DoobieDbConnection
import com.example.scala_http_api.module.video.application.create.VideoCreator
import com.example.scala_http_api.module.video.application.search.VideosSearcher
import com.example.scala_http_api.module.video.domain.VideoRepository
import com.example.scala_http_api.module.video.infrastructure.repository.DoobieMySqlVideoRepository

import scala.concurrent.ExecutionContext

final class VideoModuleDependencyContainer(
                                            doobieDbConnection: DoobieDbConnection,
                                            messagePublisher: MessagePublisher
                                          )(implicit executionContext: ExecutionContext) {
  val repository: VideoRepository = new DoobieMySqlVideoRepository(doobieDbConnection)

  val videosSearcher: VideosSearcher = new VideosSearcher(repository)
  val videoCreator: VideoCreator     = new VideoCreator(repository, messagePublisher)
}

