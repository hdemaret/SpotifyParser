package API.token

import scalaj.http.{Http, HttpResponse}

object Token {
  def getToken: String = {
    val lClientEncoded: String = "Mjc5NmNkZmRlYTNjNDQ0NGJhNzczZTM2MTM3ZmI4MDA6ZjM5MDM2ZGJkNTBjNDE1OWJiMDNhMDExMDE3MmM1MDQ"
    val lResponse: HttpResponse[String] =
      Http("https://accounts.spotify.com/api/token")
        .postForm(Seq("grant_type" -> "client_credentials"))
        .header("Authorization", "Basic " + lClientEncoded)
        .asString

    ujson.read(lResponse.body)("access_token").render().replaceAll("\"","")
  }
}
