package com.example.scala_http_api.entry_point

import com.example.scala_http_api.entry_point.controller.user.UserGetController
import com.example.scala_http_api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer

final class EntryPointDependencyContainer(
  userDependencies: UserModuleDependencyContainer
) {
  val userGetController = new UserGetController(userDependencies.usersSearcher)
}
