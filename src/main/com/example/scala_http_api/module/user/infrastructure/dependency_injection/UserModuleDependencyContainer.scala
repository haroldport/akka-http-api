package com.example.scala_http_api.module.user.infrastructure.dependency_injection

import com.example.scala_http_api.module.shared.bus.domain.MessagePublisher
import com.example.scala_http_api.module.shared.persistence.infrastructure.doobie.DoobieDbConnection
import com.example.scala_http_api.module.user.application.register.UserRegistrar
import com.example.scala_http_api.module.user.application.search.UsersSearcher
import com.example.scala_http_api.module.user.domain.UserRepository
import com.example.scala_http_api.module.user.infrastructure.repository.DoobieMySqlUserRepository

import scala.concurrent.ExecutionContext

final class UserModuleDependencyContainer(
                                           doobieDbConnection: DoobieDbConnection,
                                           messagePublisher: MessagePublisher
                                         )(implicit executionContext: ExecutionContext) {
  val repository: UserRepository = new DoobieMySqlUserRepository(doobieDbConnection)

  val usersSearcher: UsersSearcher = new UsersSearcher(repository)
  val userRegistrar: UserRegistrar = new UserRegistrar(repository, messagePublisher)
}
