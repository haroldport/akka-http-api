package com.example.scala_http_api.module.user.application.search

import com.example.scala_http_api.module.user.domain.{User, UserRepository}

final class UsersSearcher(repository: UserRepository) {

  def all(): Seq[User] = repository.all()

}
