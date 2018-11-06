package com.example.scala_http_api.module.shared.infrastructure.message_broker.rabbitmq

import com.example.scala_http_api.module.shared.bus.infrastructure.rabbit_mq.RabbitMqChannelFactory

final class RabbitMqMessagePurger(channelFactory: RabbitMqChannelFactory)(queueName: String) extends MessagePurger {
  private val channel = channelFactory.channel

  override def purgeQueue(): Unit = channel.queuePurge(queueName)
}
