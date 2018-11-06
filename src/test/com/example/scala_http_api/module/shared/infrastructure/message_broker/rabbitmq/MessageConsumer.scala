package com.example.scala_http_api.module.shared.infrastructure.message_broker.rabbitmq

import com.example.scala_http_api.module.shared.bus.domain.Message

trait MessageConsumer {
  def startConsuming(handler: Message => Boolean): Unit
  def hasMessagesToConsume: Boolean
  def isEmpty: Boolean = !hasMessagesToConsume
}
