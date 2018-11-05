package com.example.scala_http_api.module.video.infrastructure.dependency_injection

import com.example.scala_http_api.module.video.application.create.VideoCreator
import com.example.scala_http_api.module.video.application.search.VideosSearcher
import com.example.scala_http_api.module.video.infrastructure.repository.InMemoryVideoRepository

final class VideoModuleDependencyContainer {
  val repository = new InMemoryVideoRepository

  val videosSearcher = new VideosSearcher(repository)
  val videoCreator   = new VideoCreator(repository)
}
