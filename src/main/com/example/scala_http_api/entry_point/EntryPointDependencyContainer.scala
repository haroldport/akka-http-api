package com.example.scala_http_api.entry_point

import com.example.scala_http_api.entry_point.controller.status.StatusGetController
import com.example.scala_http_api.entry_point.controller.user.UserGetController
import com.example.scala_http_api.entry_point.controller.video.{VideoGetController, VideoPostController}
import com.example.scala_http_api.module.user.infrastructure.dependency_injection.UserModuleDependencyContainer
import com.example.scala_http_api.module.video.infrastructure.dependency_injection.VideoModuleDependencyContainer

final class EntryPointDependencyContainer(
  userDependencies: UserModuleDependencyContainer,
  videoDependencies: VideoModuleDependencyContainer
) {
  val statusGetController = new StatusGetController

  val userGetController = new UserGetController(userDependencies.usersSearcher)

  val videoGetController  = new VideoGetController(videoDependencies.videosSearcher)
  val videoPostController = new VideoPostController(videoDependencies.videoCreator)
}
