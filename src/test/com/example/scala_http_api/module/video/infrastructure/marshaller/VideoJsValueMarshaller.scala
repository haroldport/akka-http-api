package com.example.scala_http_api.module.video.infrastructure.marshaller

import spray.json.{JsArray, JsNumber, JsObject, JsString}
import com.example.scala_http_api.module.video.domain.Video

object VideoJsValueMarshaller {
  def marshall(videos: Seq[Video]): JsArray = JsArray(
    videos
      .map(
        v =>
          JsObject(
            "id"                  -> JsString(v.id.value.toString),
            "title"               -> JsString(v.title.value),
            "duration_in_seconds" -> JsNumber(v.duration.value.toSeconds),
            "category"            -> JsString(v.category.toString),
            "creator_id"          -> JsString(v.creatorId.value.toString)
          )
      )
      .toVector
  )
}
