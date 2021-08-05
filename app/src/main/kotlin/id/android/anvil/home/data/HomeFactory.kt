package id.android.anvil.home.data

import id.android.anvil.home.domain.HomeParams
import io.reactivex.rxjava3.core.Single

class HomeFactory(private val datasource: HomeDatasource) {

  fun nowPlaying(params: HomeParams): Single<HomeResponse> =
    datasource.nowPlaying(params.apiKey)
}