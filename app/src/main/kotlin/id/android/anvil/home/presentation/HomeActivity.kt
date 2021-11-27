package id.android.anvil.home.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.android.anvil.BuildConfig
import id.android.anvil.R
import id.android.anvil.home.domain.Home
import id.android.anvil.home.presentation.HomeViewState.Error
import id.android.anvil.home.presentation.HomeViewState.Loading
import id.android.anvil.home.presentation.HomeViewState.Success
import javax.inject.Inject
import id.android.anvil.App.Companion.component as Injector

class HomeActivity : AppCompatActivity(R.layout.activity_home) {

  @Inject lateinit var factory: ViewModelProvider.Factory

  private val viewModel: HomeView by lazy {
    ViewModelProvider(this, factory)[HomeViewModel::class.java]
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    Injector.inject(this)
    super.onCreate(savedInstanceState)

    viewModelStates()
    viewModel.fetchHome(params = Home(apiKey = BuildConfig.API_KEY))
  }

  private fun viewModelStates() {
    viewModel.states.observe(this, { state ->
      when (state) {
        is Loading -> {}
        is Success -> {}
        is Error -> {}
      }
    })
  }
}