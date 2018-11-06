package com.example.scala_http_api.entry_point.controller.user

import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.StatusCodes.NoContent
import akka.http.scaladsl.server.Directives.complete
import akka.http.scaladsl.server.StandardRoute
import com.example.scala_http_api.module.shared.user.domain.UserId
import com.example.scala_http_api.module.user.application.register.UserRegistrar
import com.example.scala_http_api.module.user.domain.UserName

final class UserPostController(registrar: UserRegistrar) {
  def post(id: String, name: String): StandardRoute = {
    registrar.register(UserId(id), UserName(name))

    complete(HttpResponse(NoContent))
  }
}
