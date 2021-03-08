package id.android.anvil.home.presentation

import androidx.lifecycle.LiveData
import id.android.anvil.home.domain.HomeParams

interface HomeView {

  val states: LiveData<HomeViewState>

  fun fetchHome(params: HomeParams)
}