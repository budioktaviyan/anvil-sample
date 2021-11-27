package id.android.anvil.home.presentation

import androidx.lifecycle.LiveData
import id.android.anvil.home.domain.Home

interface HomeView {

  val states: LiveData<HomeViewState>

  fun fetchHome(params: Home)
}