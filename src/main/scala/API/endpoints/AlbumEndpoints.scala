package API.endpoints

object AlbumEndpoints extends SpotifyEndpoints {
  private val albumEndpoint = baseAPIUrl + "/v1/albums/"

  def getAlbum(albumId: String): String = {
    callRequest(iEndpoint = albumEndpoint + albumId)
  }

  def getAlbums(albumIds: List[String]): String = {
    callRequest(iEndpoint = albumEndpoint, iParams = List(("ids", albumIds.mkString(","))))
  }

  def getAlbumTracks(albumId: String): String = {
    callRequest(iEndpoint = albumEndpoint + albumId + "/tracks")
  }
}
