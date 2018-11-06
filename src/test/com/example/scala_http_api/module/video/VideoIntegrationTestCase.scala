package com.example.scala_http_api.module.video

import com.example.scala_http_api.module.IntegrationTestCase
import com.example.scala_http_api.module.video.domain.VideoRepository
import com.example.scala_http_api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

protected[video] trait VideoIntegrationTestCase extends IntegrationTestCase {
  private val container = new VideoModuleDependencyContainer(doobieDbConnection, messagePublisher)

  protected val repository: VideoRepository = container.repository
}
