package com.example.scala_http_api.module.user.domain

import com.example.scala_http_api.module.shared.user.domain.UserId

object User {
  def apply(id: String, name: String): User = User(UserId(id), UserName(name))
}

case class User(id: UserId, name: UserName)
