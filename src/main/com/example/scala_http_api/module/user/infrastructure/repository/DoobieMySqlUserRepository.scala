package com.example.scala_http_api.module.user.infrastructure.repository

import com.example.scala_http_api.module.shared.persistence.infrastructure.doobie.DoobieDbConnection
import com.example.scala_http_api.module.user.domain.{User, UserRepository}
import doobie.implicits._
import com.example.scala_http_api.module.shared.persistence.infrastructure.doobie.TypesConversions._

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMySqlUserRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
  extends UserRepository {
  override def all(): Future[Seq[User]] = {
    db.read(sql"SELECT user_id, name FROM users".query[User].to[Seq])
  }

  override def save(user: User): Future[Unit] =
    sql"INSERT INTO users(user_id, name) VALUES (${user.id}, ${user.name})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
}
