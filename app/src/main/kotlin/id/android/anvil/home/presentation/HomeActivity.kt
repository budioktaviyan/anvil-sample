package id.android.anvil.home.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import id.android.anvil.BuildConfig
import id.android.anvil.databinding.ActivityHomeBinding
import id.android.anvil.home.domain.Home
import id.android.anvil.home.presentation.HomeViewState.Error
import id.android.anvil.home.presentation.HomeViewState.Loading
import id.android.anvil.home.presentation.HomeViewState.Success
import javax.inject.Inject
import id.android.anvil.App.Companion.component as Injector

class HomeActivity : AppCompatActivity() {

  @Inject lateinit var factory: ViewModelProvider.Factory

  private lateinit var viewBinding: ActivityHomeBinding

  private val viewModel: HomeView by lazy {
    ViewModelProvider(this, factory)[HomeViewModel::class.java]
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    Injector.inject(this)
    super.onCreate(savedInstanceState)

    viewBinding = ActivityHomeBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewModelStates()
    viewModel.fetchHome(params = Home(apiKey = BuildConfig.API_KEY))
  }

  private fun viewModelStates() {
    viewModel.states.observe(this) { state ->
      when (state) {
        is Loading -> {
          viewBinding.pbHome.visibility = View.VISIBLE
        }
        is Success -> {
          viewBinding.pbHome.visibility = View.GONE

          val adapter = HomeAdapter(state.entity.results)
          viewBinding.rvHome.adapter = adapter

          viewBinding.rvHome.visibility = View.VISIBLE
        }
        is Error -> {
          Snackbar.make(
            viewBinding.rootHome,
            "Error: ${state.error.localizedMessage}",
            Snackbar.LENGTH_LONG
          ).show()
        }
      }
    }
  }
}