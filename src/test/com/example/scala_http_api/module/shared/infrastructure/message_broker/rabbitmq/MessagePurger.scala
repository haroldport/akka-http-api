package com.example.scala_http_api.module.shared.infrastructure.message_broker.rabbitmq

trait MessagePurger {
  def purgeQueue(): Unit
}
