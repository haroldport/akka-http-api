package com.example.scala_http_api.user.infrastructure.stub

import com.example.scala_http_api.user.domain.User

object UserStub {

  def apply(
             id: String = UserIdStub.random.value.toString,
             name: String = UserNameStub.random.value
           ): User = User(id, name)

  def random: User = apply()

}
