package id.android.anvil.detail.presentation

import androidx.lifecycle.LiveData
import id.android.anvil.detail.domain.DetailEntity

interface DetailView {

  val states: LiveData<DetailViewState>

  fun loadDetail(entity: DetailEntity)
}