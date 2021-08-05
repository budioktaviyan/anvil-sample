package id.android.anvil.home.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

data class HomeResponse(
  @SerialName("results")
  val results: List<Result>?) {

  @Serializable
  data class Result(
    @SerialName("id")
    val id: Long?,

    @SerialName("title")
    val title: String?,

    @SerialName("poster_path")
    val posterPath: String?,

    @SerialName("vote_average")
    val voteAverage: Double?
  )
}