package id.android.anvil.detail.module

import androidx.lifecycle.ViewModel
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import id.android.anvil.core.scope.ApplicationScope
import id.android.anvil.detail.presentation.DetailViewModel
import id.android.anvil.core.scope.ViewModel as ViewModels

@Suppress("Unused")
@Module
@ContributesTo(ApplicationScope::class)
abstract class DetailModule {

  @Binds
  @IntoMap
  @ViewModels(DetailViewModel::class)
  abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}