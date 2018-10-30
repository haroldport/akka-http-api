package com.example.scala_http_api.module.user.infrastructure.dependency_injection

import com.example.scala_http_api.module.user.application.UsersSearcher

final class UserModuleDependencyContainer {

  val usersSearcher = new UsersSearcher

}
