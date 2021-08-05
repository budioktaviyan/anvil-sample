package id.android.anvil.home.presentation

import id.android.anvil.home.domain.HomeEntity

sealed class HomeViewState {

  object Loading : HomeViewState()

  data class Success(val entity: HomeEntity) : HomeViewState()
  data class Error(val error: Throwable) : HomeViewState()
}