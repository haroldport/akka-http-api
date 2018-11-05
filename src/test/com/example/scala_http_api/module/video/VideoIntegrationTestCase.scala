package com.example.scala_http_api.module.video

import com.example.scala_http_api.module.IntegrationTestCase
import com.example.scala_http_api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer
import com.example.scala_http_api.module.video.infrastructure.repository.InMemoryVideoRepository

protected[video] trait VideoIntegrationTestCase extends IntegrationTestCase {
  private val container = new VideoModuleDependencyContainer

  protected val repository: InMemoryVideoRepository = container.repository
}
