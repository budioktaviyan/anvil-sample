package id.android.anvil.home.domain

data class HomeEntity(val results: List<Result>) {

  data class Result(
    val title: String,
    val content: String,
    val image: String,
    val background: String,
    val rating: Double
  )
}