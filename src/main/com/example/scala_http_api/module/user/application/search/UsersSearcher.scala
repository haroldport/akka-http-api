package com.example.scala_http_api.module.user.application.search

import com.example.scala_http_api.module.user.domain.{User, UserRepository}

import scala.concurrent.Future

final class UsersSearcher(repository: UserRepository) {
  def all(): Future[Seq[User]] = repository.all()
}
