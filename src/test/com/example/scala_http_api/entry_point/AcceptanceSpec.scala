package com.example.scala_http_api.entry_point

import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import akka.util.ByteString
import com.example.scala_http_api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.example.scala_http_api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

protected[entry_point] abstract class AcceptanceSpec
  extends WordSpec
    with Matchers
    with ScalaFutures
    with ScalatestRouteTest {
  private val routes = new Routes(
    new EntryPointDependencyContainer(
      new UserModuleDependencyContainer,
      new VideoModuleDependencyContainer
    )
  )

  def get[T](path: String)(body: ⇒ T): T = Get(path) ~> routes.all ~> check(body)

  def post[T](path: String, request: String)(body: ⇒ T): T =
    HttpRequest(
      method = HttpMethods.POST,
      uri    = path,
      entity = HttpEntity(
        MediaTypes.`application/json`,
        ByteString(request)
      )
    ) ~> routes.all ~> check(
      body
    )
}
