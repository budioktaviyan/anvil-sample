package id.android.anvil.home.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import id.android.anvil.BuildConfig
import id.android.anvil.R
import id.android.anvil.databinding.ActivityHomeBinding
import id.android.anvil.detail.domain.DetailEntity
import id.android.anvil.detail.presentation.DetailActivity
import id.android.anvil.home.domain.Home
import id.android.anvil.home.domain.HomeEntity.Result
import id.android.anvil.home.presentation.HomeViewState.Error
import id.android.anvil.home.presentation.HomeViewState.Loading
import id.android.anvil.home.presentation.HomeViewState.Success
import javax.inject.Inject
import id.android.anvil.App.Companion.component as Injector

class HomeActivity : AppCompatActivity(), HomeAdapterCallback {

  @Inject lateinit var factory: ViewModelProvider.Factory

  private lateinit var viewBinding: ActivityHomeBinding

  private val viewModel: HomeView by lazy {
    ViewModelProvider(this, factory)[HomeViewModel::class.java]
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    Injector.inject(this)
    super.onCreate(savedInstanceState)

    title = resources.getString(R.string.now_playing)

    viewBinding = ActivityHomeBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewModelStates()
    viewModel.fetchHome(params = Home(apiKey = BuildConfig.API_KEY))
  }

  override fun onClick(result: Result) {
    startActivity(
      Intent(this, DetailActivity::class.java).apply {
        putExtra(
          DetailActivity::class.java.simpleName,
          DetailEntity(
            title = result.title,
            content = result.content,
            background = result.background,
            rating = result.rating
          )
        )
      }
    )
  }

  private fun viewModelStates() {
    viewModel.states.observe(this) { state ->
      when (state) {
        is Loading -> {
          viewBinding.pbHome.visibility = View.VISIBLE
        }
        is Success -> {
          viewBinding.pbHome.visibility = View.GONE

          val adapter = HomeAdapter(this, state.entity.results)
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