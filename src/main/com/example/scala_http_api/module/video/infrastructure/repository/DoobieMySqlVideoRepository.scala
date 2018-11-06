package com.example.scala_http_api.module.video.infrastructure.repository

import doobie.implicits._
import com.example.scala_http_api.module.video.domain.{Video, VideoRepository}
import com.example.scala_http_api.module.shared.persistence.infrastructure.doobie.DoobieDbConnection
import com.example.scala_http_api.module.shared.persistence.infrastructure.doobie.TypesConversions._

import scala.concurrent.{ExecutionContext, Future}

final class DoobieMySqlVideoRepository(db: DoobieDbConnection)(implicit executionContext: ExecutionContext)
  extends VideoRepository {
  override def all(): Future[Seq[Video]] =
    db.read(sql"SELECT video_id, title, duration_in_seconds, category, creator_id FROM videos".query[Video].to[Seq])

  override def save(video: Video): Future[Unit] =
    sql"INSERT INTO videos(video_id, title, duration_in_seconds, category, creator_id) VALUES (${video.id}, ${video.title}, ${video.duration}, ${video.category}, ${video.creatorId})".update.run
      .transact(db.transactor)
      .unsafeToFuture()
      .map(_ => ())
}
