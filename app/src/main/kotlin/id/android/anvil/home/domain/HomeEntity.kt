package id.android.anvil.home.domain

data class HomeEntity(val results: List<Result>) {

  data class Result(
    val id: Long,
    val title: String,
    val image: String,
    val rating: Double
  )
}