package com.example.scala_http_api.module.video.application.search

import com.example.scala_http_api.module.UnitTestCase
import com.example.scala_http_api.module.video.domain.VideoStub
import com.example.scala_http_api.module.video.infrastructure.repository.VideoRepositoryMock

final class VideosSearcherShould extends UnitTestCase with VideoRepositoryMock {
  private val searcher = new VideosSearcher(repository)

  "search all existing videos" in {
    val existingVideo        = VideoStub.random
    val anotherExistingVideo = VideoStub.random
    val existingVideos       = Seq(existingVideo, anotherExistingVideo)

    repositoryShouldFind(existingVideos)

    searcher.all().futureValue shouldBe existingVideos
  }
}
