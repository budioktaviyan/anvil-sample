package id.android.anvil.detail.presentation

import id.android.anvil.detail.domain.DetailEntity

sealed class DetailViewState {

  data class Success(val entity: DetailEntity) : DetailViewState()
}