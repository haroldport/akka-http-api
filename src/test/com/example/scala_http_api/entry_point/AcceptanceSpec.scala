package com.example.scala_http_api.entry_point

import akka.http.scaladsl.testkit.ScalatestRouteTest
import com.example.scala_http_api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{Matchers, WordSpec}

protected[entry_point] abstract class AcceptanceSpec extends WordSpec with Matchers with ScalaFutures with ScalatestRouteTest {

  private val routes = new Routes(
    new EntryPointDependencyContainer(
      new UserModuleDependencyContainer,
    )
  )
  def get[T](path: String)(body: ⇒ T): T = Get(path) ~> routes.all ~> check(body)

}
