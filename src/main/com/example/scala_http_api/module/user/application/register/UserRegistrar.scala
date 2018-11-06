package com.example.scala_http_api.module.user.application.register

import com.example.scala_http_api.module.shared.bus.domain.MessagePublisher
import com.example.scala_http_api.module.shared.user.domain.UserId
import com.example.scala_http_api.module.user.domain._

final class UserRegistrar(repository: UserRepository, publisher: MessagePublisher) {
  def register(id: UserId, name: UserName): Unit = {
    val user = User(id, name)

    repository.save(user)

    publisher.publish(UserRegistered(user))
  }
}
