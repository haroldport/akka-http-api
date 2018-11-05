package com.example.scala_http_api.module.user.domain

trait UserRepository {
  def all(): Seq[User]
}
