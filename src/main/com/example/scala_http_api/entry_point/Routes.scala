package com.example.scala_http_api.entry_point

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.example.scala_http_api.entry_point.controller.status.StatusGetController

final class Routes(container: EntryPointDependencyContainer) {

  val all: Route = get {
    path("status")(StatusGetController()) ~
    path("users")(container.userGetController.get())
  }

}
