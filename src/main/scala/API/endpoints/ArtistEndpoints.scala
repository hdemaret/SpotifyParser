package API.endpoints

object ArtistEndpoints extends SpotifyEndpoints {
  private val artistEndpoint = baseAPIUrl + "/v1/artists/"

  def getArtist(artistId: String): String = {
    callRequest(iEndpoint = artistEndpoint + artistId)
  }

  def getArtists(artistIds: List[String]): String = {
    callRequest(iEndpoint = artistEndpoint, iParams = List(("ids", artistIds.mkString(","))))
  }

  def getArtistAlbums(artistId: String): String = {
    callRequest(iEndpoint = artistEndpoint + artistId + "/albums")
  }

  def getArtistTopTracks(artistId: String, country: String = "US"): String = {
    callRequest(iEndpoint = artistEndpoint + artistId + "/top-tracks", iParams = List(("country", country)))
  }

  def getRelatedArtists(artistId: String): String = {
    callRequest(iEndpoint = artistEndpoint + artistId + "/related-artists")
  }
}
