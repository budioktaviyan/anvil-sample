package id.android.anvil.home.domain

import id.android.anvil.BuildConfig
import id.android.anvil.home.data.HomeFactory
import id.android.anvil.home.domain.HomeEntity.Result
import io.reactivex.rxjava3.core.Single

interface HomeRepository {

  fun fetchHome(params: Home): Single<HomeEntity>
}

class HomeRepositoryImpl(private val factory: HomeFactory) : HomeRepository {

  override fun fetchHome(params: Home): Single<HomeEntity> =
    factory.nowPlaying(params).map { response ->
      val results = response.results ?: emptyList()

      HomeEntity(results = results.map { result ->
        val id = result.id ?: -1L
        val title = result.title ?: "Untitled"
        val image = "${BuildConfig.IMAGE_URL}/${result.posterPath ?: "untitled.jpg"}"
        val rating = result.voteAverage ?: 0.0

        Result(id = id, title = title, image = image, rating = rating)
      })
    }
}