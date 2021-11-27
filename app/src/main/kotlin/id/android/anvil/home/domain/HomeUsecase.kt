package id.android.anvil.home.domain

import io.reactivex.rxjava3.core.Single

class HomeUsecase(private val repository: HomeRepository) {

  fun fetchHome(params: Home): Single<HomeEntity> =
    repository.fetchHome(params)
}