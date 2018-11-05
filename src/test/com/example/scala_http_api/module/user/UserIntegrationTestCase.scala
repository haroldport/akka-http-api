package com.example.scala_http_api.module.user

import com.example.scala_http_api.module.IntegrationTestCase
import com.example.scala_http_api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.example.scala_http_api.module.user.infrastructure.repository.InMemoryUserRepository

protected[user] trait UserIntegrationTestCase extends IntegrationTestCase {
  private val container = new UserModuleDependencyContainer

  protected val repository: InMemoryUserRepository = container.repository
}
