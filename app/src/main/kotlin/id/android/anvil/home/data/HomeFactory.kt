package id.android.anvil.home.data

import id.android.anvil.home.domain.Home
import io.reactivex.rxjava3.core.Single

class HomeFactory(private val datasource: HomeDatasource) {

  fun nowPlaying(params: Home): Single<HomeResponse> =
    datasource.nowPlaying(params.apiKey)
}