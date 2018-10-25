package com.example.scala_http_api

import org.scalatest._
import org.scalatest.Matchers._

final class ScalahttpapiTest extends WordSpec with GivenWhenThen {
  "Scalahttpapi" should {
    "greet" in {
      Given("a Scalahttpapi")

      val scalahttpapi = new Scalahttpapi

      When("we ask him to greet someone")

      val nameToGreet = "CodelyTV"
      val greeting    = scalahttpapi.greet(nameToGreet)

      Then("it should say hello to someone")

      greeting shouldBe "Hello " + nameToGreet
    }
  }
}
