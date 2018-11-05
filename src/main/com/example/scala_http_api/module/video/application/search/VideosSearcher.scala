package com.example.scala_http_api.module.video.application.search

import com.example.scala_http_api.module.video.domain.{Video, VideoRepository}

final class VideosSearcher(repository: VideoRepository) {
  def all(): Seq[Video] = repository.all()
}
