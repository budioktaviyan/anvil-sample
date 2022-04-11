package id.android.anvil.detail.presentation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import id.android.anvil.databinding.ActivityDetailBinding
import id.android.anvil.detail.domain.DetailEntity
import id.android.anvil.detail.presentation.DetailViewState.Success
import javax.inject.Inject
import id.android.anvil.App.Companion.component as Injector

class DetailActivity : AppCompatActivity() {

  @Inject lateinit var factory: ViewModelProvider.Factory

  private lateinit var viewBinding: ActivityDetailBinding

  private val viewModel: DetailView by lazy {
    ViewModelProvider(this, factory)[DetailViewModel::class.java]
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    Injector.inject(this)
    super.onCreate(savedInstanceState)

    supportActionBar?.apply { setDisplayHomeAsUpEnabled(true) }

    viewBinding = ActivityDetailBinding.inflate(layoutInflater)
    setContentView(viewBinding.root)

    viewModelStates()

    val entity = intent.getParcelableExtra<DetailEntity>(DetailActivity::class.java.simpleName)
    entity?.let { detailEntity -> viewModel.loadDetail(detailEntity) }
  }

  override fun onSupportNavigateUp(): Boolean {
    onBackPressed()

    return super.onSupportNavigateUp()
  }

  private fun viewModelStates() {
    viewModel.states.observe(this) { state ->
      when (state) {
        is Success -> {
          title = state.entity.title

          val adapter = DetailAdapter(state.entity)
          viewBinding.rvDetail.adapter = adapter

          viewBinding.rvDetail.visibility = View.VISIBLE
        }
      }
    }
  }
}