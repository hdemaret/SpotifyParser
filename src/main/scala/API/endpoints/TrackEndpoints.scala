package API.endpoints

object TrackEndpoints extends SpotifyEndpoints {
  private val tracksEndpoint = baseAPIUrl + "/v1/tracks/"

  def getTrack(trackId: String): String =
    callRequest(tracksEndpoint + trackId)

  def getTracks(trackIds: List[String]): String =
    callRequest(tracksEndpoint, iParams = List(("ids", trackIds.mkString(","))))
}
