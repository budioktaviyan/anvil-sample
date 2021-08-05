package id.android.anvil.home.domain

import id.android.anvil.BuildConfig
import id.android.anvil.home.data.HomeFactory
import id.android.anvil.home.domain.HomeEntity.Result
import io.reactivex.rxjava3.core.Single

interface HomeRepository {

  fun fetchHome(params: HomeParams): Single<HomeEntity>
}

class HomeRepositoryImpl(private val factory: HomeFactory) : HomeRepository {

  override fun fetchHome(params: HomeParams): Single<HomeEntity> =
    factory.nowPlaying(params).map { response ->
      val results = response.results ?: emptyList()

      HomeEntity(results = results.map { result ->

        Result(
          id = result.id ?: -1L,
          title = result.title ?: "Untitled",
          image = "${BuildConfig.IMAGE_URL}/${result.posterPath ?: "untitled.jpg"}",
          rating = result.voteAverage ?: 0.0
        )
      })
    }
}