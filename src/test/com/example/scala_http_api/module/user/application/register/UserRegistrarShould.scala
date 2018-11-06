package com.example.scala_http_api.module.user.application.register

import com.example.scala_http_api.module.UnitTestCase
import com.example.scala_http_api.module.shared.infrastructure.MessagePublisherMock
import com.example.scala_http_api.module.user.domain.{UserRegisteredStub, UserStub}
import com.example.scala_http_api.module.user.infrastructure.repository.UserRepositoryMock

final class UserRegistrarShould extends UnitTestCase with UserRepositoryMock with MessagePublisherMock {
  private val registrar = new UserRegistrar(repository, messagePublisher)

  "register a user" in {
    val user           = UserStub.random
    val userRegistered = UserRegisteredStub(user)

    repositoryShouldSave(user)

    publisherShouldPublish(userRegistered)

    registrar.register(user.id, user.name).shouldBe(())
  }
}
